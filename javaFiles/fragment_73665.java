public static void main(String[] args) throws IOException, TransformerException {
    PdfDocument pdf = new PdfDocument(new PdfReader(SRC));
    PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
    XfaForm xfa = form.getXfaForm();
    Document doc = xfa.getDomDocument();
    DOMSource domSource = new DOMSource(doc);
    StringWriter writer = new StringWriter();
    StreamResult result = new StreamResult(writer);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.transform(domSource, result);
    writer.flush();
    System.out.println(writer.toString());
}