String input = "<response><result><phone>1233</phone><sys_id>asweyu4</sys_id><link>rft45fgd</link></result><result><phone>1233</phone><sys_id>another-sysid</sys_id><link>another-link</link></result></response>";
Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        .parse(new ByteArrayInputStream(input.getBytes("UTF-8")));
XPath path = XPathFactory.newInstance().newXPath();
NodeList node = (NodeList) path.compile("//response/result/sys_id").evaluate(doc, XPathConstants.NODESET);
for (int i = 0; i < node.getLength(); i++) {
    System.out.println(node.item(i).getTextContent());
}