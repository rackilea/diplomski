// Assume lexing, etc. already done before this point
ParserRuleContext<Token> tree = parser.myMainRule(); // Do parse

ParseTreeWalker walker = new ParseTreeWalker(); // Premade utility class
PrintingFooListener listener = new PrintingFooListener(); // Your customized subclass 
walker.walk(listener, tree);