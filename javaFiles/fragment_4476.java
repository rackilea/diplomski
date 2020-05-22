// this handles doc files
public class DocExtractorDoc extends DocExtractor {

    // constructor
    public class DocExtractorDoc(File f) {
        // this calls the DocExtractor constructor which has common code for all constructors
        super(f);
        // put code specific to the DocExtractorDoc constructor here
    }

    // concrete implementation of the getText method specific to doc files
    public String getText() {
        // getText code for doc files goes here
    }
}

// this handles xls files
public class DocExtractorXls extends DocExtractor {

    // constructor
    public class DocExtractorXls(File f) {
        // this calls the DocExtractor constructor which has common code for all constructors
        super(f);
        // put code specific to the DocExtractorXls constructor here
    }

    // concrete implementation of the getText method specific to xls files
    public String getText() {
        // getText code for xls files goes here
    }
}