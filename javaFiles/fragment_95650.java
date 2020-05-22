class ThisWorksOK {

    public ThisWorksOK() {
    }

    public void createPdf() {
        ...
        PdfFont font = PdfFontFactory.createFont(...);
        Paragraph p = new Paragraph("test").setFont(font);
        document.add(p);
        ...
    }
}