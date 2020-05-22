public class CustomIndexWriter implements Serializable {


    private static final long serialVersionUID = 1L;

    private transient IndexWriter luceneIndexWriter;

    public CustomIndexWriter(IndexWriter luceneIndexWriter) {
         this.luceneIndexWriter=luceneIndexWriter;
    }

    public IndexWriter getLuceneIndexWriter() {
        return luceneIndexWriter;
    }

    public void setLuceneIndexWriter(IndexWriter luceneIndexWriter) {
        this.luceneIndexWriter = luceneIndexWriter;
    }


}