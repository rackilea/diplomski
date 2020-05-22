private String upperCase(String str) {
    Document document = Jsoup.parse(str);
    upperCase(document.body());
    return document.html();
}

private void upperCase(Node node) {
    if (node instanceof TextNode) {
        TextNode textnode = (TextNode) node;
        textnode.text(textnode.text().toUpperCase());
    }
    for (Node child : node.childNodes()) {
        upperCase(child);
    }
}