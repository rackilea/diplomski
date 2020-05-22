public InputStream convertDocument(InputStream dataStream) throws Exception {
    // just acts as a pass through since already in pdf format
    PipedOutputStream os = new PipedOutputStream();
    PipedInputStream is = new PipedInputStream(os);

    System.setProperty("org.apache.pdfbox.baseParser.pushBackSize", "2024768"); //for large files

    PDDocument doc = PDDocument.load(dataStream, true);

    if (doc.isEncrypted()) { //remove the security before adding protections
        doc.decrypt("");
        doc.setAllSecurityToBeRemoved(true);
    }
    doc.save(os);
    doc.close();
    dataStream.close();
    os.close();
    return is;
}