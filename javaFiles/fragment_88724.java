DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

Document doc = builder.parse(new ByteArrayInputStream(resp.getBytes("UTF-8")));

XPath xPath = XPathFactory.newInstance().newXPath();

System.out.printf("Status: %s\n", xPath.evaluate("//subscription/@status", doc));
System.out.printf("Charge Method: %s\n", xPath.evaluate("//charge-method//text()", doc));