String folder = "/home/user/report/";
    InputStream is = new FileInputStream(folder + "test.pdf");
    PdfReader reader = new PdfReader(is);

    for (int i = 1; i <= reader.getNumberOfPages(); i++) {
        File tmp = new File(folder + "out" + i +".pdf");
        FileOutputStream outStream = new FileOutputStream(tmp);
        Document pdDoc = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(pdDoc, outStream);
        pdDoc.open();
        PdfContentByte cb = writer.getDirectContent();
        PdfImportedPage page = writer.getImportedPage(reader, i);
        pdDoc.newPage();
        cb.addTemplate(page, 0, 0);
        pdDoc.close();
    }