XmlPullParser xpp = context.getResources().getXml(R.xml.zoo_table);
    XPath xpath = XPathFactory.newInstance().newXPath();
    try {
        String askFor2 = "//creature[@ID='2']";
        NodeList creaturesNodes = (NodeList) xpath.evaluate(askFor2, xpp, XPathConstants.NODESET);

        // here you have all such creatures - the list of one node in your case