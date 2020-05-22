try {

                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document dom = db.parse(new StringBufferInputStream(currentLine));
                    Element docEle = dom.getDocumentElement();
                    dom.getDocumentElement().normalize();

                    logger.info("Root element :" + dom.getDocumentElement().getNodeName());

                    /* Iterate over companies */
                    NodeList messageListNodes = docEle.getChildNodes();
                    if (messageListNodes != null) { 
                        int length = messageListNodes.getLength();                      
                        for (int i = 0; i < length; i++) {

                            if(messageListNodes.item(i) instanceof Element){
                                message.setId(UUID.fromString(messageListNodes.item(i).getTextContent()));
                                message.setCompany(messageListNodes.item(1).getTextContent());
                                message.setContent(messageListNodes.item(2).getTextContent());

                            }

                            logger.debug( name+ company + content);
                            messagelist.add(message);
                        }

                    }