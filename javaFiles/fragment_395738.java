String parser = XMLResourceDescriptor.getXMLParserClassName();
        SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
        URL url = new URL(getCodeBase(), "fileName.svg");
        Document doc = f.createDocument(url.toString());

        Element svg = doc.getDocumentElement();

        if (svg.hasAttribute("viewBox")) {
          // notify the user somehow
        }