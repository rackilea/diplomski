Element jdomRoot = jdomDocument.getRootElement();

    List<Element> children = jdomRoot.getChildren();
    for (Element child : children) {
        System.out.println(child.getAttributeValue("name"));
    }