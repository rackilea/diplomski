String[] fields = {"title", "body", "subject", "author"};
QueryParser[] parsers = new QueryParser[fields.length];      
for(int i = 0; i < parsers.length; i++)
{
   parsers[i] = new QueryParser(Version.LUCENE_35, fields[i], analyzer);
   parsers[i].setDefaultOperator(QueryParser.AND_OPERATOR);
}