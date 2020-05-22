PdfReader pdfIn = new PdfReader("source.pdf");
    Document document = new Document(getNormalizedPageSize(pdfIn), 0, 0, 0, 0);
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:/target.pdf"));
    document.open();
    PdfContentByte cb = writer.getDirectContent();

    for (int i = 1; i <= pdfIn.getNumberOfPages(); i++) {
        PdfImportedPage page = writer.getImportedPage(pdfIn, i);
        document.setPageSize(new Rectangle(page.getHeight(), page.getWidth()));
        document.newPage();
        float min = Math.min(page.getHeight(), page.getWidth());
        AffineTransform rotateInstance = AffineTransform.getRotateInstance(Math.PI / 2,
                min / 2.0, min / 2.0);
        double[] matrix = new double[6];
        rotateInstance.getMatrix(matrix);
        cb.addTemplate(page, (float) matrix[0], (float) matrix[1], (float) matrix[2],
                (float) matrix[3], (float) matrix[4], (float) matrix[5]);
    }
    document.close();