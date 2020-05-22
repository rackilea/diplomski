int n = 0;
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("1.xml"));
    NodeList list = doc.getElementsByTagName("TESTSTEP");
    for (int i = 0; i < list.getLength(); i++) {
        Element e = (Element) list.item(i);
        if (e.getAttribute("ORDER_NUMBER").equals("0")) {
            n += e.getElementsByTagName("TEST").getLength();
        }
    }