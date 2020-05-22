public abstract class DocExtractor {

    // constructor
    public DocExtractor(File f) {
       poiFile = f;
    }

    // the getText method must be defined by all derived classes
    public abstract String getText();

    // this protected field is visible to all classes which extend DocExtractor
    protected File poiFile;

}