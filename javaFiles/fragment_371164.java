NodeList components = xPathAPI.eval(doc, "//errors/error").nodelist();
        System.out.println("components.getLength()" + components.getLength());
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        for (int i = 0; i < components.getLength(); i++) {
            Node component = components.item(i);
            Element product = (Element) component;
            NodeList nodes = (NodeList) xpath.compile("error_source").evaluate(product, XPathConstants.NODESET);
            System.out.println(nodes.item(0).getTextContent());
        }