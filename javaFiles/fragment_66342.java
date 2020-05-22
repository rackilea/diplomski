int current = 0;
        int total = 0;
        for ( int x = 0; x < children.getLength(); x++ ) {
            Node elem = children.item(x);

            switch ( elem.getNodeName() ) {
                case "current":
                    current = Integer.parseInt(elem.getTextContent());
                    break;
                case "total":
                    total = Integer.parseInt(elem.getTextContent());
                    break;
            }

        }
        if(current > 0 && total > 0 && current < total) {
            Element element = (Element) elem;
            element.getElementsByTagName("current").item(0).setTextContent(Integer.toString(current + 10));
        }