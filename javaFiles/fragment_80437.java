DocumentBuilderFactory odbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder odb =  odbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xml));
            Document odoc = odb.parse(is);
            odoc.getDocumentElement().normalize ();    // normalize text representation
            System.out.println ("Root element of the doc is " + odoc.getDocumentElement().getNodeName());
            NodeList LOP = odoc.getElementsByTagName("locations");
            int totalPersons =LOP.getLength();
            System.out.println("Total nos of locations:"+totalPersons);

            for(int s=0; s<LOP.getLength() ; s++)
            {
                Node FPN =LOP.item(s);
                if(FPN.getNodeType() == Node.ELEMENT_NODE)
                    {

                    Element latlon = (Element)FPN;                                                                // Change 1

                    NodeList oNameList1 = latlon.getElementsByTagName("featured");                                       // Change 2
                    Element firstNameElement = (Element)oNameList1.item(0);
                    NodeList textNList1 = firstNameElement.getChildNodes();
                    //this.setLocationId(((Node)textNList1.item(0)).getNodeValue().trim());    // Change 3
                    featuredArr = changeToBoolean(((Node)textNList1.item(0)).getNodeValue().trim());                                    // value taken
                    System.out.println("#####The Parsed data#####");
                    System.out.println("featured : " + ((Node)textNList1.item(0)).getNodeValue().trim());            // Change 4
                    System.out.println("#####The Parsed data#####");