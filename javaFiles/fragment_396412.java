BooleanQuery bothQuery = new BooleanQuery();

                                         // field, value
TermQuery idQuery1 = new TermQuery(new Term("ID1", "id1"));
TermQuery idQuery2 = new TermQuery(new Term("ID2", "id2"));

bothQuery.add(new BooleanClause(idQuery1, BooleanClause.Occur.MUST));
bothQuery.add(new BooleanClause(idQuery2, BooleanClause.Occur.MUST));

TopDocs topDocs = searcher.search(bothQuery, 1);
Document doc = searcher.doc(topDocs.scoreDocs[0].doc)