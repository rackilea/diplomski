@Override
public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {

    if (qName.equalsIgnoreCase("file")) {
        String name = attributes.getValue("name");
        String size = attributes.getValue("size");
        file file = new file (name,size);
        list.add(file);
        }
      }