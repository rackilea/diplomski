@ManagedBean(name = "documentBean")
@ViewScoped
public class DocumentBean {

private List<DocumentVO> documents;
private DocumentVO selectedDocument;
private StreamedContent content;
private ActionListener openDocumentActionListener;

@EJB
private DocumentServiceIntegrator documentIntegrator;
private static final Log LOG = LogFactory.getLog(DocumentBean.class);

@PostConstruct
public void init() {
    documents = documentIntegrator.getFolderContentByPath("/");
    selectedDocument = new DocumentVO();
    openDocumentActionListener = createOpenDocumentActionListener();
}

public ActionListener createOpenDocumentActionListener() {
    ActionListener actionListener = new ActionListener() {
        @Override
        public void processAction(ActionEvent arg0) throws AbortProcessingException {
            LOG.info("Open document: " + selectedDocument.getId() + " (" + selectedDocument.getName() + ", " + selectedDocument.getMimeType() + ")");
            byte[] bytes = documentIntegrator.getDocumentContentById(selectedDocument.getId());
            LOG.info("Document content: " + (bytes != null ? bytes.length + " bytes" : "null"));
            InputStream stream = new ByteArrayInputStream(bytes);
            content = new DefaultStreamedContent(stream, selectedDocument.getMimeType(), selectedDocument.getName());
        }
    };
    return actionListener;
}

// getters and setters for: documents, selectedDocument, content and openDocumentActionListener

}