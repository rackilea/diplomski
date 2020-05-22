NodeList ParentList = doc.getElementsByTagName("task");
        for (int i = 0; i < ParentList.getLength(); i++) {
            NamedNodeMap attributes = ParentList.item(i).getAttributes();

            for (int index = 0; index < attributes.getLength(); index++) {
                Node attribute = attributes.item(index);
                System.out.println("Parent is "+ attribute.getNodeValue());
            }

            NodeList childList = ParentList.item(i).getChildNodes();

            for (int j = 0; j < childList.getLength(); j++) {
               String text = childList.item(j).getTextContent();
               if (text.trim().length() != 0) {
                System.out.println("Clild is "+ text);
               }
            }
        }