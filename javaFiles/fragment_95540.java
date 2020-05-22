DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document dom = db.parse("employees.xml");
Element element = (Element) dom.getElementsByTagName("app_type").item(0);
NodeList nodes = dom.getElementsByTagName('"tagName");
int count = nodes.getLength();