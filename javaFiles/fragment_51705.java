String xPathStr = "/soapenv:Envelope/soapenv:Body/*[name()='addListResponse']"
            + "/platformMsgs:writeResponseList"
            + "/platformCore:status/@isSuccess"
            // + "/platformMsgs:writeResponse/platformCore:status/platformCore:statusDetail/platformCore:message";
            ;
    String xPathStr2 = "/soapenv:Envelope/soapenv:Body/*[name()='addListResponse']"
            + "/platformMsgs:writeResponseList"
            + "/platformMsgs:writeResponse"
            + "/platformCore:status"
            + "/platformCore:statusDetail"
            + "/platformCore:message";
            ;
    XPath xPath = XPathFactory.newInstance().newXPath();
    Map<String, String> prefMap = new HashMap<String, String>() {
        {
            put("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            put("xsd", "http://www.w3.org/2001/XMLSchema");
            put("xsi", "http://www.w3.org/2001/XMLSchema-instance");
            put("platformMsgs", "urn:messages_2015_1.platform.webservices.netsuite.com");
            put("platformCore", "urn:core_2015_1.platform.webservices.netsuite.com");
        }
    };
    xPath.setNamespaceContext(new SimpleNamespaceContext(prefMap));
    System.out.println(
            "Expression value: " + xPath.evaluate(xPathStr, new InputSource(new StringReader(example))));
    System.out.println(
            "Expression value: " + xPath.evaluate(xPathStr2, new InputSource(new StringReader(example))));