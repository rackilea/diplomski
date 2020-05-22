ExecutionContext executionContext = stepExecution.getExecutionContext();
SerializableLuceneObjects slObjects = (SerializableLuceneObjects)executionContext.get("luceneObjects");
IndexWriter luceneIndexWriter = slObjects.getLuceneIndexWriter();
IndexReader luceneIndexReader = slObjects.getLuceneIndexReader();
if(luceneIndexWriter !=null ) luceneIndexWriter.close();
if(luceneIndexReader != null) luceneIndexReader.close();