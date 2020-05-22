public class DocExtractorFactory {

    public static DocExtractor create(File f) {
        // create the appropriate DocExtractor derived class based on the file extension
        String extension = FilenameUtils.getExtension(f.getName());
        if (extension.equals("doc") {
            return new DocExtractorDoc(f);
        } else if (extension.equals("xls") {
            return new DocExtractorXls(f);
        } else {
            // error handling code here -- perhaps throw an exception
        }
    }
}