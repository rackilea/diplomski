public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader,
            new FileOutputStream(dest));
    AcroFields fields = stamper.getAcroFields();
    fields.setField("student", "Anil Pradhan");
    fields.setField("age", "25");
    stamper.close();
    reader.close();
}