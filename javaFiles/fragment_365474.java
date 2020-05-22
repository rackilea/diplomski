SAXReader reader = new SAXReader();
Document document = reader.read(file);
List<Node> nodes = document.selectNodes("/options/category/option");

for (Node node : nodes) {
    System.out.println("caption: " + node.selectSingleNode("control/caption").getText());
    System.out.println("value : " + node.selectSingleNode("value").getText());
}