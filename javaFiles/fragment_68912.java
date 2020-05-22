public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    AcroFields form = stamper.getAcroFields();
    form.removeXfa();
    form.setField("topmostSubform[0].Page2[0].p2_cb01[0]", "1");
    form.setField("topmostSubform[0].Page2[0].p2_cb01[1]", "2");
    form.setField("topmostSubform[0].Page2[0].p2_cb01[2]", "3");
    form.setField("topmostSubform[0].Page2[0].p2_cb01[3]", "4");
    form.setField("topmostSubform[0].Page2[0].p2_cb01[4]", "5");
    form.setField("topmostSubform[0].Page2[0].p2_cb01[5]", "6");
    stamper.close();
    reader.close();
}