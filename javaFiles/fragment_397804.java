XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr1 = xpath.compile("/environments/environment");
            XPathExpression expr2 = xpath.compile("@key");
            XPathExpression expr12 = xpath.compile("variable");
            XPathExpression expr121 = xpath.compile("@name");
            XPathExpression expr122 = xpath.compile("@value");

            NodeList environmentNL = (NodeList) expr1.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < environmentNL.getLength(); i++) {
                Node environmentI = environmentNL.item(i);
                String envKey =  (String) expr2.evaluate(environmentI, XPathConstants.STRING);


                NodeList variableNL = (NodeList) expr12.evaluate(environmentI, XPathConstants.NODESET);
                for (int j = 0; j < variableNL.getLength(); j++) {
                    Node variableI = variableNL.item(j);
                    String valueName =  (String) expr121.evaluate(variableI, XPathConstants.STRING);
                    String valueValue =  (String) expr122.evaluate(variableI, XPathConstants.STRING);

                    val.put(envKey+"."+valueName, valueValue);

                }
            }