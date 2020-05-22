public class TestDocumentRepositoryImpl implements TestDocumentRepository {

    private SolrOperations solrTemplate;
    ...
    public CustomSolrRepositoryImpl(SolrOperations solrTemplate) {
        super();
        this.solrTemplate = solrTemplate;
    }

    @Override
    public TestDocument findOneSpecifyingCollection(String collection, String id) {
        return solrTemplate.getById(collection, id, TestDocument.class);
    }
}