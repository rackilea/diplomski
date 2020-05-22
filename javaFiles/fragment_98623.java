DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse("testxml.xml");

            Element root = doc.getDocumentElement();

            NodeList nodelist1 = root.getChildNodes();

            String[] st = null;
            List<String> texts = new ArrayList<String>();
            for (int i = 0; i < nodelist1.getLength(); i++)
            {
                Node node = nodelist1.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE ) 
                {
                    texts.add( node.getTextContent() );

                }
            }

            st = texts.toArray( new String[]{} );


            System.out.println( Arrays.toString( st ) );

            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

            model.addRow(  st );

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.print("error");
        }