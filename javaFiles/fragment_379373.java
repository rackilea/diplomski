XmlMapper NodeMap = new XmlMapper();
final ObjectWriter writer = NodeMap.writer().withRootName("Pumpernickel"); //Rename as appropriate

ObjectNode rootNode = NodeMap.createObjectNode();
ObjectNode currentNode = rootNode.putObject("Examples");
currentNode
    .put("Puppy", true)
    .put("Apple", 2)
    .put("Jet", "Li");
currentNode = rootNode.putObject("Single");
currentNode.put("One", 1);

String writePath = "C:/users/itsameamario/Documents/basicXMLtest.xml";
writer.writeValue(new File(writePath), rootNode); // Make sure you replace this line too.