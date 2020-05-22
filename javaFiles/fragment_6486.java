public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("component")) {
                String classname = attributes.getValue("classname");
                String name = attributes.getValue("name");
                System.out.println("path du componsant= " + classname + "  nom de composant est " + name);
                bName = true;
            }
            if (qName.equalsIgnoreCase("attribute")) {
                temp = attributes.getValue("name");

                lab=attributes.getValue("label");
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            if (temp != null) {
                if (temp.equalsIgnoreCase("temperature")) {

                    label = lab;
                } else if (temp.equalsIgnoreCase("t")) {
                    System.out.println("temp " + temp + " lab " + lab);
                    if (lab.equals(label)) {
                        System.out.println("okk");
                    } else {
                        System.out.println("not ok");
                    }
                }
                blabel = false;
                bnameatt = false;
            }
        }