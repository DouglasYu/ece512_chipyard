package chipyard

import freechips.rocketchip.config.{Config}

// ---------------------
// BOOM Configs
// ---------------------

class SmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(1) ++                          // small boom config
  new chipyard.config.AbstractConfig)

class requiredFirstBoomConfig extends Config(
  new boom.common.requiredFirstBooms(1) ++                          // small boom config
  new chipyard.config.AbstractConfig)

class requiredSecondBoomConfig extends Config(
  new boom.common.requiredSecondBooms(1) ++                          // small boom config
  new chipyard.config.AbstractConfig)

class myFirstBoomConfig extends Config(
  new boom.common.myFirstBooms(1) ++                          // small boom config
  new chipyard.config.AbstractConfig)

class mySecondBoomConfig extends Config(
  new boom.common.mySecondBooms(1) ++                          // small boom config
  new chipyard.config.AbstractConfig)

class NlLargeBoomConfig extends Config(
  new boom.common.WithNlPrefetcherLargeBooms(1) ++               // large boom with NL prefetcher
  new chipyard.config.AbstractConfig)

class StrideLargeBoomConfig extends Config(
  new boom.common.WithNlPrefetcherLargeBooms(1) ++               // large boom with stride prefetcher. Note: you need to change mshrs.scala
  new chipyard.config.AbstractConfig)

class NlLargerDCacheLargeBoomConfig extends Config(
  new boom.common.WithNlPrefetcherLargerDCacheLargeBooms(1) ++   // large boom with NL prefetcher, larger D-cache size
  new chipyard.config.AbstractConfig)

class NlSmallerDCacheLargeBoomConfig extends Config(
  new boom.common.WithNlPrefetcherSmallerDCacheLargeBooms(1) ++  // large boom with NL prefetcher, smaller D-cache size
  new chipyard.config.AbstractConfig)

class LargerDCacheLargeBoomConfig extends Config(
  new boom.common.LargerDCacheLargeBooms(1) ++                  // large boom without NL prefetcher, larger D-cache size
  new chipyard.config.AbstractConfig)

class SmallerDCacheLargeBoomConfig extends Config(
  new boom.common.SmallerDCacheLargeBooms(1) ++                 // large boom without NL prefetcher, smaller D-cache size
  new chipyard.config.AbstractConfig)

class MediumBoomConfig extends Config(
  new boom.common.WithNMediumBooms(1) ++                         // medium boom config
  new chipyard.config.AbstractConfig)

class LargeBoomConfig extends Config(
  new boom.common.WithNLargeBooms(1) ++                          // large boom config
  new chipyard.config.AbstractConfig)

class MegaBoomConfig extends Config(
  new boom.common.WithNMegaBooms(1) ++                           // mega boom config
  new chipyard.config.AbstractConfig)

class DualSmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(2) ++                          // 2 boom cores
  new chipyard.config.AbstractConfig)

class HwachaLargeBoomConfig extends Config(
  new chipyard.config.WithHwachaTest ++
  new hwacha.DefaultHwachaConfig ++                              // use Hwacha vector accelerator
  new boom.common.WithNLargeBooms(1) ++
  new chipyard.config.AbstractConfig)

class LoopbackNICLargeBoomConfig extends Config(
  new chipyard.harness.WithLoopbackNIC ++                        // drive NIC IOs with loopback
  new icenet.WithIceNIC ++                                       // build a NIC
  new boom.common.WithNLargeBooms(1) ++
  new chipyard.config.AbstractConfig)

class DromajoBoomConfig extends Config(
  new chipyard.harness.WithSimDromajoBridge ++                   // attach Dromajo
  new chipyard.config.WithTraceIO ++                             // enable the traceio
  new boom.common.WithNSmallBooms(1) ++
  new chipyard.config.AbstractConfig)
