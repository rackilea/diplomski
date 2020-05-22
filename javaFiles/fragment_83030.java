Document doc = new SAXBuilder().build("locations.kml");

    Namespace ns = Namespace.getNamespace("http://www.opengis.net/kml/2.2");
    Namespace ns2 = Namespace.getNamespace("gx", "http://www.google.com/kml/ext/2.2");

    Element rootNode = doc.getRootElement();
    Element docNode = rootNode.getChild("Document",ns);
    Element folNode = docNode.getChild("Folder",ns);

    List<Element> list = folNode.getChildren("Placemark",ns);

    if(!list.isEmpty())
    {
        Element node = list.get(0);
        Element tracknode = node.getChild("Track",ns2);

        Element newWhen = new Element("when",ns);
        newWhen.setText("WHEN");

        Element newCoord = new Element("coord",ns2);
        newCoord.setText("WHERE");

        Element firstcoord = tracknode.getChild("coord",ns2);
        tracknode.addContent(tracknode.indexOf(firstcoord), newWhen);
        tracknode.addContent(newCoord);

    }

    XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
    outputter.output(doc, System.out);