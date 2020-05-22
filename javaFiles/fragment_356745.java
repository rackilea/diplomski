NodeList nodePhysical = dom.getElementsByTagName("observation");
    for (int i = 0; i < nodePhysical.getLength(); i++) {
    Node node = nodePhysical.item(i);
    NodeList childNodes = node.getChildNodes();
    Element ele;
    for (int count = 0; count < childNodes.getLength(); count++) {
    ele= (Element) childNodes.item(count);
    ele.setAttribute("value",ele.getAttribute("value").split("\\.")[0]);
    }
    }