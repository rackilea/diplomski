NodeList nodeList = doc.getElementsByTagName("cmd");
                    //Check <cmd> tag is present and then check <cmd> tag has child nodes
                    if (nodeList != null && nodeList.item(0).hasChildNodes()) {
                        //Get first child node of <cmd> xml tag
                        String nodeName = doc.getElementsByTagName("cmd").item(0).getFirstChild().getNodeName();

                        NodeList childNodeList = doc.getElementsByTagName(nodeName);
                        Element el = (Element) childNodeList.item(0);
                        //set pgd_login attribute with respective value
                        el.setAttribute("login", "xyz");

                        //Convert back into xml string from Document
                        xml = XMLHelpers.TransformDOMDocumentToString(doc);
                    }