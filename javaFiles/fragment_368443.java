public class DynamicXML3 {

    private static final String SEPARTOR = "\\.";

    public static void main(String args[]) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            Document document = builder.newDocument();

            Map<String, String> data = new HashMap<String, String>();
            data.put("A.B.C.C1.C11", "C11");
            data.put("A.B.C.C1.C12", "C12");
            data.put("A.B.C.C2.C21", "C21");
            data.put("A.B.C.C2.C22", "C22");
            data.put("A.B.C.C3.C31", "C31");
            data.put("A.B.C.C.D", "D");

            Iterator<Entry<String, String>> it = data.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> pair = (Map.Entry<String, String>)it.next();
                System.out.println(pair.getKey() + " = " + pair.getValue());
                appendElement(document, pair.getKey(), pair.getValue());
                it.remove();
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("C:/Users/Desktop/BuddyCode.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }
    }

    private static void appendElement(Document document, String key, String value) {
        String[] splitedElements = key.split(SEPARTOR);
        for (int i = 0; i < splitedElements.length; i++) {
            NodeList nlst = document.getElementsByTagName(splitedElements[i]);
            if(nlst == null || nlst.getLength() == 0) {
                if(i==0) {
                    document.appendChild(document.createElement(splitedElements[i]));
                } else {
                    (document.getElementsByTagName(splitedElements[i-1]).item(0)).appendChild(document.createElement(splitedElements[i]));
                }
                if(i==(splitedElements.length-1)) {
                    (document.getElementsByTagName(splitedElements[i]).item(0)).appendChild(document.createTextNode(value));
                }
            }
        }
    }

}