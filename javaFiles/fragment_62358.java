Document xml1 = new SAXBuilder().build(new StringReader("<geodata>\n"
                + " <person name=\"tom\">\n"
                + "       <address>2344 States Drive, MA 01213, USA</address>\n"
                + "       <phonenumber>333-222-2222</phonenumber>\n"
                + " </person>\n"
                + " <person name=\"mat\">\n"
                + "       <address>2345 Gates Drive, PA 11213, USA</address>\n"
                + "       <phonenumber>444-222-2222</phonenumber>\n"
                + " </person>\n"
                + "</geodata>"));
        Document xml2 = new SAXBuilder().build(new StringReader("<salarydata>\n"
                + " <person name=\"mat\">\n"
                + "       <salary>$3000</salary>\n"
                + "       <pension>$500</pension>\n"
                + " </person>\n"
                + " <person name=\"tom\">\n"
                + "       <salary>$3500</salary>\n"
                + "       <pension>$700</pension>\n"
                + " </person>\n"
                + "</salarydata>"));

        List<Element> geodata = xml1.getRootElement().getChildren();
        List<Element> salarydata = xml2.getRootElement().getChildren();
        //Element root = new Element("persondata");
        for (Element e : geodata) {
            for (Element e2 : salarydata) {
                if (e.getAttributeValue("name").equals(e2.getAttributeValue("name"))) {
                    e.addContent(e2.removeContent());
                }
            }
        }
        Element rootNode = xml1.getRootElement();
        rootNode.setName("persondata");
        new XMLOutputter().output(xml1, System.out);