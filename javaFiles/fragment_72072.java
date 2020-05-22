//WHOLE_BUNCHES is a constant representing a reasonable max number of docs we want to pull here.
//Integer.MAX_VALUE would probably invite an OutOfMemoryError, but that would be true of the
//implementation in the question anyway, since they were still being stored in the list at the end.
query.setRows(WHOLE_BUNCHES);
QueryResponse response = solr.query(query);
int totalResults = (int) response.getResults().getNumFound(); //If you even still need this figure.
List<Article> ret = response.getBeans(Article.class);