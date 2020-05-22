Document doc = null;
    Namespace kmlns = new Namespace("http://www.opengis.net/kml/2.2");
    Element position = new Element("Position", kmlns);
    position.addContent(new Element("name", kmlns).setText(positionName));
    position.addContent(new Element("desc", kmlns).setText(description));
    position.addContent(.....   all the XML content needed for the Position ....);

    // create the XML Document in memory if the file does not exist
    // otherwise read the file from the disk
    if(!test.exists()){
            doc = new Document();
            Element root = new Element("kml", kmlns);
    } else {
            SAXBuilder sb = new SAXBuilder();
            doc = sb.build(test);
    }

    Element root = doc.getRootElement();
    // modify the XML as you need
    // add Position Element
    root.addContent(position);

    try {
        fwriter = new FileWriter(datapath+"/"+name+".kml");
        XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());
        xout.output(doc, writer);
        fwriter.flush();
        fwriter.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }