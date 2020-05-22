public class TestSearchEngine implements SearchEngine<Tag> {

private static final String INDEX_PATH = "/test/index";

private Directory directory;
@Inject private TagDAO tagDAO;
private int organizationId;

private static final Object mutex = new Object();

@Override
public void add(Tag tag) {
    IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35));        
    IndexWriter indexWriter = getIndexWriter(indexWriterConfig);

    //Create document
    Document document = new Document();
    document.add(new Field("id", String.valueOf(tag.getId()), Field.Store.YES, Field.Index.NOT_ANALYZED));
    document.add(new Field("title", tag.getTitle(), Field.Store.NO, Field.Index.ANALYZED));

    try {
        indexWriter.addDocument(document);
        indexWriter.close();
    } catch (CorruptIndexException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Override
public void setDirectory(int organizationId) throws IOException {

      synchronized (mutex) {
        this.organizationId = organizationId;
        File path = new File(INDEX_PATH + "/" + String.valueOf(organizationId));

        //If path does not exist, create it and create new index for organization
        if(!path.exists()) {
           path.mkdirs();
           buildCompleteIndex(organizationId, false);
        }

        this.directory = FSDirectory.open(path); //Open directory
      }
}

private void buildCompleteIndex(int organizationId, boolean rebuildDir) {
    if(rebuildDir) {
        File path = new File(INDEX_PATH + "/" + String.valueOf(organizationId));
        try {
            Utils.deleteDirectory(path);
        } catch (IOException e) {
            throw new LuceneIndexException("Error rebuilding index directory.", e);
        }
        path.mkdirs();
    }

    List<Tag> tagList = tagDAO.findAll(organizationId);
    for(Tag tag : tagList) {
        add(tag);
    }
}

private IndexReader getIndexReader() {
    try {
        return IndexReader.open(directory);
    } catch (CorruptIndexException e) {
        buildCompleteIndex(organizationId, true);
    } catch (IOException e) {
        throw new LuceneIndexException("IOException prevented IndexReader from opening Index.", e);
    } catch(NullPointerException e) {
        throw new LuceneIndexException("Index resource not available.", e);
    }
    return null;
}