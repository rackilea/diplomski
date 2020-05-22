private String getTextContent(Element elem) {
    String text = elem.getContent().toString();

    final List<Element> children = elem.getChildElements();
    for (Element child : children) {
        text = text.replace(child.toString(), "");
    }
    return text;
}