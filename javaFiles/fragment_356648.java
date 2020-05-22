163       // A user-settable upper limit on the maximum amount of allocatable direct
 164       // buffer memory.  This value may be changed during VM initialization if
 165       // "java" is launched with "-XX:MaxDirectMemorySize=<size>".
 166       //
 167       // The initial value of this field is arbitrary; during JRE initialization
 168       // it will be reset to the value specified on the command line, if any,
 169       // otherwise to Runtime.getRuntime.maxDirectMemory().
 170       //
 171       private static long directMemory = 64 * 1024 * 1024;