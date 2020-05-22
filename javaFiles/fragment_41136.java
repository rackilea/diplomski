if (e.isStartElement() &&
                ((StartElement) e).getName().getLocalPart().equals("tagINeed")){
            xw = of.createXMLEventWriter(sw);
            xw.add(e);
        } else if (e.isEndElement() &&
                ((EndElement) e).getName().getLocalPart().equals("tagINeed")){
            xw.add(e);
            break;
        } else if (xw != null) {
            xw.add(e);
        }