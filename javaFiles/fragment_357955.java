$ java -XX:+UseG1GC  -XX:+UnlockDiagnosticVMOptions -XX:+PrintFlagsFinal -version | grep -i 'duplicat'
    uintx StringDeduplicationAgeThreshold          = 3                                        {product} {default}
     bool StringDeduplicationRehashALot            = false                                 {diagnostic} {default}
     bool StringDeduplicationResizeALot            = false                                 {diagnostic} {default}
     bool UseStringDeduplication                   = false                                    {product} {default}
java version "9"
Java(TM) SE Runtime Environment (build 9+181)
Java HotSpot(TM) 64-Bit Server VM (build 9+181, mixed mode)