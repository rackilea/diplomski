$ java -XX:+UseG1GC  -XX:+UnlockDiagnosticVMOptions -XX:+PrintFlagsFinal -version | grep -i 'duplicat'
     bool PrintStringDeduplicationStatistics        = false                               {product}
    uintx StringDeduplicationAgeThreshold           = 3                                   {product}
     bool StringDeduplicationRehashALot             = false                               {diagnostic}
     bool StringDeduplicationResizeALot             = false                               {diagnostic}
     bool UseStringDeduplication                    = false                               {product}
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)