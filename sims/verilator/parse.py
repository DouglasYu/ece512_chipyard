import argparse
import os
import re

def main(args):
    benchmarks = ["dhrystone", "median", "mm", "mt-matmul", "mt-vvadd", "multiply", "qsort", "spmv", "towers", "vvadd"]
    path = os.path.join("/home/zeduoyu2/chipyard/sims/verilator/output/", args.logs_path)
    files = os.listdir(path)
    
    for bench in benchmarks:
        log_path = os.path.join(path, bench + ".riscv.log")
        with open(log_path, 'r') as f:
            content = f.read()
            if bench in ["dhrystone", "median", "multiply", "qsort", "spmv", "towers", "vvadd"]:
                # print(content)
                res = re.search(r"mcycle = (\d*)", content).group(1)
                cycles = float(res)
                res = re.search(r"minstret = (\d*)", content).group(1)
                insts = float(res)
                ipc = insts / cycles
            elif bench == "mm":
                res = re.search(r"C0: ([0-9]*) cycles", content).group(1)
                cycles = float(res)
                res = re.search(r"C0: ([0-9]*) instructions", content).group(1)
                insts = float(res)
                ipc = insts / cycles
            elif bench in ["mt-matmul", "mt-vvadd"]:
                res = re.search(r"(\d+\.\d*) CPI", content).group(1)
                ipc = 1 / float(res)

            print(f"{bench : <15}: {ipc}")


if __name__ == "__main__":

    parser = argparse.ArgumentParser()

    parser.add_argument('logs_path', help="Name of the folder of all the logs from run-bmark-tests.")

    args = parser.parse_args()
    main(args)