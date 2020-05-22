public ByteArrayOutputStream manipulatePdf(InputStream in, String field) throws Exception {

    System.out.println("pdfediter got hit");

    ByteArrayOutputStream bytedata = new ByteArrayOutputStream();
    try {
        PdfReader reader = new PdfReader(in);

        PdfStamper stamper = new PdfStamper(reader, bytedata);
        AcroFields form = stamper.getAcroFields();
        Item item = form.getFieldItem("Name");
        PdfDictionary widget = item.getWidget(0);
        PdfArray rect = widget.getAsArray(PdfName.RECT);
        rect.set(2, new PdfNumber(rect.getAsNumber(2).floatValue() + 20f));
        String value = field;
        form.setField("Name", value);
        form.setField("Company", value);
        stamper.close();
    } catch (Exception e) {
        System.out.println("Error in manipulate");
        System.out.println(e.getMessage());
        throw e;
    }
    return bytedata;
}

public String editandzip (String data, String Link) {
    try {
        System.out.println("opening connection");
        URL url = new URL(Link);
        InputStream in = url.openStream();

        System.out.println("in : "+ url);

        //String data  = "working ok with main";
        PdfEditor writetopdf = new PdfEditor();
        ByteArrayOutputStream bao = writetopdf.manipulatePdf(in, data);
        byte[] ba = bao.toByteArray();

        File f = new File("C:/Users/JayAcer/workspace/test/test.zip");


        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry entry = new ZipEntry("newform.pdf");
        entry.setSize(ba.length);
        zos.putNextEntry(entry);
        zos.write(ba);


        zos.close();
        in.close();
        System.out.println("File downloaded");
    } catch (Exception e) {
        System.out.println("Error");
        e.printStackTrace();
    }
    return data;

}