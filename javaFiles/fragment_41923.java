{
    /*
     * Scope is restricted to the block with '{}' braces 
     */
    String tmp; 
    if ((tmp = functionWithALotOfProcessingTime()) != null) {
        // tmp is valid in this scope
        // do something with tmp
    }
}

tmp = "out of scope"; // Compiler Error - Out of scope (Undefined)