public void createPackage(String uploadedZipLocation) throws BadException, IOException, SAXException {
    String extractedFolderPath = uploadedZipLocation.split("\\.zip")[0];
    File tempFolder = null;
    StreamSource xml = null;
    FileInputStream file = null;

    try {
        file = new FileInputStream(extractedFolderPath + "/web.xml");
        xml = new StreamSource(file);
        validatePkgXml(xml, extractedFolderPath + "/web.xml");
        xml.getInputStream().close(); 
        //xml = null; 
    } catch (IOException e) {
        xml.getInputStream().close(); 
        throw e;
    } catch (BadException bpe) {
        //xml = null;
        xml.getInputStream().close(); 
        tempFolder = new File(extractedFolderPath);
        FileUtils.deleteDirectory(tempFolder); // **** Can't delete the folder because it is in use.  web.xml is still being read in validatePkgXml I think
        throw bpe;
    }
}