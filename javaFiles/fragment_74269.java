CharStream in = new ANTLRInputStream(input);
CGrammarLexer lexer = new CGrammarLexer(in);
CommonTokenStream tokens = new CommonTokenStream(lexer);
// Instead of doing this...
// CGrammarParser parser = new CGrammarParser(tokens);
// Do this...
CallableParser parser = new CallableParser(tokens);