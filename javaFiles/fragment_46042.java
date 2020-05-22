$ export JAVA_TOOL_OPTIONS='-Xmx2G'
$ java -XX:+PrintFlagsFinal -version | grep -iE 'MaxHeapSize'
Picked up JAVA_TOOL_OPTIONS: -Xmx2G
    uintx MaxHeapSize                              := 2147483648                          {product}
openjdk version "1.8.0_40-internal"
OpenJDK Runtime Environment (build 1.8.0_40-internal-b27)
OpenJDK 64-Bit Server VM (build 25.40-b25, mixed mode)