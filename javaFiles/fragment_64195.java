Node testNode = doc.getDocumentElement();
NodeList testCases= testNode.getChildNodes();

for(int i=0; i < testCases.getLength(); i++) {
    Node n = testCases.item(i);

    if (!(n instanceof Text)) {
        Element testCase = (Element) n;

        if (testCase.getAttribute("classname").contains("Clerk")) {
            clerk.add(testCase);
        } else if (testCase.getAttribute("classname").contains("Quarantine")) {
            quara.add(testCase);
        } else {
            misc.add(testCase);
        }
    }
}