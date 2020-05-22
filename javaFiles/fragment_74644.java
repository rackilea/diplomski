DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse( new File( file ) );

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();

        XPathExpression expr = xpath.compile( "//string/text()");

        Object eval = expr.evaluate( doc, XPathConstants.NODESET );
        List<String> textValues = new ArrayList<String>();
        if ( eval != null && eval instanceof NodeList )
        {
            NodeList list = (NodeList)eval;
            for ( int i = 0 ; i < list.getLength(); i++ )
            {
                Node node = list.item(i);
                String text = node.getNodeValue().trim();

                if ( !text.isEmpty() )
                {
                    System.out.println( text );
                    textValues.add( text );
                }
            }
        }