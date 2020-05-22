DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);

        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.parse("sample1.xml");

        DocumentFragment frag1 = doc.createDocumentFragment();

        Element param = (Element)doc.getElementsByTagName("param5").item(0);

        while (param.hasChildNodes())
        {
            frag1.appendChild(param.getFirstChild());
        }