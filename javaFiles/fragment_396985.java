public static void main(String[] args) throws Exception {

    String inputfilepath = "YOUR_PATH/YOUR.docx";

    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new java.io.File(inputfilepath));
    MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();        

    org.docx4j.wml.Document wmlDocumentEl = (org.docx4j.wml.Document)documentPart.getJaxbElement();

    Writer out = new OutputStreamWriter(System.out);

    org.docx4j.TextUtils.extractText(wmlDocumentEl, out);

    out.close();

}