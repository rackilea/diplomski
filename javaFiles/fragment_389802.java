BooleanQuery b = new BooleanQuery();

Set<String> fields = params.keySet();
StandardAnalyzer analyzer = new StandardAnalyzer(version);

b.add(new TermQuery(new Term("cs-method", "GET"), BooleanClause.Occur.SHOULD);
b.add(new TermQuery(new Term("cs-uri", "/blank"), BooleanClause.Occur.SHOULD);

Query q = new QueryParser(version, "cs-method", analyzer).parse(b.toString());