public void write(Writer writer, SolrQueryRequest solrQueryRequest, SolrQueryResponse solrQueryResponse) throws IOException {
    LOGGER.info("Here we are....");
    SolrIndexSearcher searcher = solrQueryRequest.getSearcher();
    NamedList namedList = solrQueryResponse.getValues();
    LOGGER.info("Named List " + namedList.size());
    int size = namedList.size();
    for (int i = 0; i < size; i++) {
        Object val = namedList.getVal(i);
        LOGGER.info(val.toString());
        if (val instanceof BasicResultContext) {
            BasicResultContext basicResultContext = (BasicResultContext) val;
            DocList docList = basicResultContext.getDocList();
            LOGGER.info("docList List " + docList.size());
            DocIterator docIterator = docList.iterator();
            writer.append("<ul>\n");
            while (docIterator.hasNext()) {
                int id = docIterator.nextDoc();
                LOGGER.info("id id " + id);
                Document doc = searcher.doc(id, fields);
                for (String field : fields) {
                    String value = doc.get(field);
                    LOGGER.info(value);
                    if (!StringUtils.isEmpty(value)) {
                        writer.append("<li>" + value + "</li>");
                    }
                }
            }
            writer.append("</ul>\n");
        }
    }
}