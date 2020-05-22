public List<String> mySqlStatementsFrom(String sourceCode) {
    List<String> statements = new ArrayList<>();
    mySqlStatementsToConsumer(sourceCode, statements::add);
    return statements;
}

public void mySqlStatementsToConsumer(String sourceCode, Consumer<String> mySqlStatementConsumer) {
    CharStream codePointCharStream = CharStreams.fromString(sourceCode);
    MySqlLexer tokenSource = new MySqlLexer(new CaseChangingCharStream(codePointCharStream, true));
    TokenStream tokenStream = new CommonTokenStream(tokenSource);
    MySqlParser mySqlParser = new MySqlParser(tokenStream);

    SqlStatementListener statementListener = new SqlStatementListener(mySqlStatementConsumer);
    ParseTreeWalker.DEFAULT.walk(statementListener, mySqlParser.sqlStatements());
}