IModel fileModel = new LoadableDetachableModel (){
    protected Object load() { 
        // A hello world PDF
        File f = File.createTempFile("tempFile", null);
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(f));
        document.open();
        document.add(new Paragraph("Hello World!"));
        document.close();
        return f;
    }
};

DownloadLink link = new DownloadLink(linkId, fileModel, "report.pdf");
// If you want to delete the file after it's been downloaded
link.setDeleteFileAfterDownload(true); 
add(link);