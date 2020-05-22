String html = "<html><body><div><p>Test Data</p> <div> <p>HELLO World</p></div></div> other text</body></html>";

Document doc = Jsoup.parse(html);
List<Node> children = doc.childNodes();

// We will search nodes in a breadth-first way
Queue<Node> nodes = new ArrayDeque<>();

nodes.addAll(doc.childNodes());

while (!nodes.isEmpty()) {
    Node n = nodes.remove();

    if (n instanceof TextNode && ((TextNode) n).text().trim().length() > 0) {
        // Do whatever you want with n.
        // Here we just print its text...
        System.out.println(n.parent().nodeName()+" contains text: "+((TextNode) n).text().trim());
    } else {
        nodes.addAll(n.childNodes());
    }
}