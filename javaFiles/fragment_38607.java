public class ModelExportThread implements Runnable {

    private final OntModel model;
    private final OutputStream outputStream;

    public ModelExportThread(OntModel model, OutputStream outputStream) {
        this.model = model;
        this.outputStream = outputStream;
    }

    public void run() {
        try {
            model.write(outputStream, "RDF/XML-ABBREV");
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(OntologyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}