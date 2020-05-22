DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse("xml");

// optional, but recommended
// read this -
// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
doc.getDocumentElement().normalize();

// System.out.println("Root element :" +
// doc.getDocumentElement().getNodeName());

// This breaks the document apart by the specified tag
NodeList nList = doc.getElementsByTagName("fastbranch-xe-request");

// For each instance of the "fastbranch-xe-request" tag...
for (int pos = 0; pos < nList.getLength(); pos++) {
    Node nNode = nList.item(pos);

    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

        Element eElement = (Element) nNode;

        // This gets you: "massiveSelectBranchList_By_Institution_Facade"
        String transactionID = eElement.getAttribute("transaction-id");

        // This gets you: "glb.credential"
        String entityName = eElement.getElementsByTagName("entity").item(0).
                getAttributes().getNamedItem("name").toString();

        // Continue this until you've pulled the tag names from each
        // "attribute" tag.  Once you've pulled all the names (and parsed
        // the values as well), you can use DOM to construct the second
        // XML request.
    }
}