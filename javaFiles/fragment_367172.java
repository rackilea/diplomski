InsertData insertDataExpr = (InsertData)updateExpr;

RDFParser parser = new SPARQLUpdateDataBlockParser();
StatementCollector handler = new StatementCollector();
parser.setRDFHandler(handler);

parser.parse(new StringReader(insertDataExpr.getDataBlock()), "");

Collection<Statement> stmts = handler.getStatements();