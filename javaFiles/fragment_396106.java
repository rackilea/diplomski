private void foo() {
    long start = System.currentTimeMillis(); // inserted by bytecode manipulation
    Profiler.enterMethod("foo"); // inserted by bytecode manipulation
    try { // inserted by bytecode manipulation
        //  original method code
    } finally { // inserted by bytecode manipulation
        Profiler.exitMethod("foo", System.currentTimeMillis() - start); // inserted by bytecode manipulation
    } // inserted by bytecode manipulation
}