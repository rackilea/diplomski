@SuppressWarnings("serial")
Map<String, String> attributesNames = new HashMap<String, String>() {
    {
        put("a", "href");
        put("img", "src");
    }
};

for (Element elt : doc.select(String.join(",", attributesNames.keySet())) {
    String elementTagName = elt.tagName();
    String attributeName = attributesNames.get(elementTagName);

    if (attributeName == null) {
        throw new RuntimeException("Unexpected element: " + elementTagName);
    }

    elt.attr(attributeName, elt.absUrl(attributeName));
}