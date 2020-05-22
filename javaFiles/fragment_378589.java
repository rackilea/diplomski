variableDeclarationContext ctx = .... ;
TerminalNode typeNode = (TerminalNode) ctx.type().getChild(0);

switch(typeNode.getSymbol().getType()) {
  case YourLexer.T_INTEGER:
     ...