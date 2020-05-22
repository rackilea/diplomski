// Existing code
else if(t.getType() == TokenType.REP) {
     ...
}
// New code starts here
else if(t.getType() == TokenType.QUOTE) {
    // This "command" is only used when parsing the input string.
    return new CMDNode(t.getType());
}
// Existing code again
else {
    throw new SyntaxError();
}