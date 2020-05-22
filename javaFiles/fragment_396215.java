int docCount = indexReader.numDocs();
IndexSearcher searcher = new IndexSearcher(indexReader);

Query queryI = new TermQuery(new Term(fieldName, termI));
Query queryJ = new TermQuery(new Term(fieldName, termJ));

Query queryIJ = new BooleanQuery();
queryIJ.add(new BooleanClause(queryI, BooleanClause.Occur.SHOULD));
queryIJ.add(new BooleanClause(queryJ, BooleanClause.Occur.SHOULD));

int countI = searcher.search(nqueryI, maxDocs).totalHits;
int countIJ = searcher.search(, maxDocs).totalHits;

float confidence = (float)countIJ / (float)countI;
float support = (float)countIJ / (float)docCount;