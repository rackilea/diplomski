TransformerFactory tf = TransformerFactory
    .newInstance();
Transformer transformer = tf.newTransformer();
transformer.setOutputProperty(
    OutputKeys.DOCTYPE_SYSTEM, "xmlValidate.dtd");
transformer.transform(new StreamSource(
    "xmlValidate.xml"), new StreamResult(System.out));