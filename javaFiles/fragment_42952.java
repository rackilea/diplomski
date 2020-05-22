Element jdomRoot = jdomDocument.getRootElement();

    List<Element> people = jdomRoot.getDescendants(new ElementFilter("person"));
    for (Element person: people) {
        System.out.println(person.getChild("name").getText());
    }