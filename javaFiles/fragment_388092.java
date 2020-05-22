String sStringToParse;

// put your XML value into the sStringToParse variable
sStringToParse = new String("<PrintLetterBarcodeData uid='741647613082' name='Pasikanti Enosh Kumar' gender='M' yob='1992' co='S/O Srinivas' house='SPLD-986' street='MALLARAM' loc='P V COLONY' vtc='Manuguru' po='P.V.Township' dist='Khammam' state='Andhra Pradesh' pc='507125'/>");

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setValidating(false);
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(new ByteArrayInputStream(sStringToParse.getBytes("utf-8")));
NodeList nlRecords = doc.getElementsByTagName("PrintLetterBarcodeData");

int num = nlRecords.getLength();

for (int i = 0; i < num; i++) {
    Element node = (Element) nlRecords.item(i);

    System.out.println("List attributes for node: " + node.getNodeName());

    // get a map containing the attributes of this node
    NamedNodeMap attributes = node.getAttributes();

    // get the number of nodes in this map
    int numAttrs = attributes.getLength();

    for (int j = 0; j < numAttrs; j++) {
        Attr attr = (Attr) attributes.item(j);

        String attrName = attr.getNodeName();
        String attrValue = attr.getNodeValue();

        // Do your stuff here
        System.out.println("Found attribute: " + attrName + " with value: " + attrValue);

    }

}