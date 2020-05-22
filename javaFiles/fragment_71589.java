// A user-settable upper limit on the maximum amount of allocatable direct
// buffer memory.  This value may be changed during VM initialization if
// "java" is launched with "-XX:MaxDirectMemorySize=<size>".
//
// The initial value of this field is arbitrary; during JRE initialization
// it will be reset to the value specified on the command line, if any,
// otherwise to Runtime.getRuntime().maxMemory().
//
private static long directMemory = 64 * 1024 * 1024;