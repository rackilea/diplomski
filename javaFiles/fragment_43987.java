boolean onceMore(){
    String next = Compiler.inputQueue.peek();
    return next.equalsIgnoreCase(Tokens.sAUDIO) ||
           next.equalsIgnoreCase(Tokens.sBOLD) ||
           ...;
}