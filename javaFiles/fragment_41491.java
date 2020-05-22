Node e = document.getDocumentElement().getFirstChild();

    // final DOMSerializerImpl ds = new DOMSerializerImpl();
    final DOMImplementationLS ls = (DOMImplementationLS) document
        .getImplementation().getFeature("LS", "3.0");
    final LSSerializer ser = ls.createLSSerializer();
    ser.getDomConfig().setParameter("xml-declaration", false);

    do {
    if (e.getNodeType() == Node.ELEMENT_NODE) {
        final Element el = (Element) e;
        if ("true".equals(el.getAttribute("bad"))) {
        // System.out.println("bad!!");
        final String sTextReplace = ser.writeToString(el);
        el.getParentNode().replaceChild(
            document.createComment(sTextReplace), el);
        }
        e = e.getNextSibling();
    }
    } while (e != null);

    document.getDocumentElement().normalize();

    System.out.println(ser.writeToString(document));