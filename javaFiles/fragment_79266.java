DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse("D:\\test.xml");

        Element root = doc.getDocumentElement();

        NodeList nodelist1 =
                root.getChildNodes();

        String[] st = new String[4];

        for (int i = 0; i < nodelist1.getLength(); i++)
        {
            Node node = nodelist1.item(i);
            if (node.getNodeType() == node.ENTITY_NODE) {
                st[0] = node.getChildNodes().item(1).getTextContent();
                st[1] = node.getChildNodes().item(3).getTextContent();
                st[2] = node.getChildNodes().item(5).getTextContent();
                st[3] = node.getChildNodes().item(7).getTextContent();
                ((DefaultTableModel) jTable1.getModel()).addRow(st);
            }

        }