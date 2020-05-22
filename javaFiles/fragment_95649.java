class ThisGoesWrong {

    protected PdfFont font;

    public ThisGoesWrong() {
        font = PdfFontFactory.createFont(...);
    }

    public void createPdf() {
        ...
        Paragraph p = new Paragraph("test").setFont(font);
        document.add(p);
        ...
    }
}