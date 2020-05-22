InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(s));

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();;
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(is);
            Element docEle = dom.getDocumentElement ();

            NodeList nl = docEle.getChildNodes();

            if (nl != null) {
                int length = nl.getLength();
                for (int i = 0; i < length; i++) {
                    if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        Element el = (Element) nl.item(i);
                        if (el.getNodeName().contains("account")) {
                            user_id = el.getElementsByTagName("id").item(0).getTextContent();
                            user_fname = el.getElementsByTagName("fname").item(0).getTextContent();
                            user_lname = el.getElementsByTagName("lname").item(0).getTextContent();
                            user_status = el.getElementsByTagName("status").item(0).getTextContent();
                        }
                    }
                }
            }