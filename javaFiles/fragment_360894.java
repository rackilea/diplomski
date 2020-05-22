TermRangeQuery dateQuery = new TermRangeQuery("created_at",lowerDate, upperDate, includeLower, includeUpper);
TermQuery keywordQuery = new TermQuery(new Term("keyword", "term"));
BooleanQuery bq = new BooleanQuery();
bq.add(new BooleanClause(dateQuery, BooleanClause.Occur.MUST))
bq.add(new BooleanClause(keywordQuery, BooleanClause.Occur.MUST))

// display search results
TopDocs topDocs = searcher.search(bq, 10);