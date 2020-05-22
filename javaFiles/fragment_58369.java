public static void main(String[] args) throws Exception {

        File xsltFile = new File("mardownXSLT.xslt");

        Source xmlSource = new StreamSource(new StringReader(theHTML));
        Source xsltSource = new StreamSource(xsltFile);

        TransformerFactory transFact =
                TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);

        StringWriter result = new StringWriter();
        trans.transform(xmlSource, new StreamResult(result));
    }