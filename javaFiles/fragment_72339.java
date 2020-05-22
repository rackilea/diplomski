String sql = "SELECT CUST_NAME FROM CUSTOMERS WHERE CUST_NAME LIKE 'Kash%'";

MySqlLexer lexer = new MySqlLexer(CharStreams.fromString(sql));
MySqlParser parser = new MySqlParser(new CommonTokenStream(lexer));
ParseTree root = parser.dmlStatement();

System.out.println(root.toStringTree(parser));