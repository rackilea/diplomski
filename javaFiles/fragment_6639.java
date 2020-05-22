private OMElement marshallMapIntoElements(String responseName, LinkedHashMap responseMap)
  {
    OMFactory fac = OMAbstractFactory.getOMFactory();
    OMNamespace omNS = fac.createOMNamespace("http://something.com/w-ww", "w-w-w");
    OMElement responseElement = fac.createOMElement(responseName, omNS);
    Iterator responseIterator = responseMap.keySet().iterator();
    responseElement.addChild(recursiveMapRetrive(responseMap,responseElement));
    return responseElement;
  }

  public OMElement recursiveMapRetrive(LinkedHashMap<String, Object> response, OMElement responseElement) {

        for (Map.Entry<String, Object> entry : response.entrySet()) {
            OMFactory fac = OMAbstractFactory.getOMFactory();
            OMNamespace omNS = fac.createOMNamespace("http://services.xm.org/xsd", "tns");
            OMElement fieldElement1 = responseElement;
            LinkedHashMap responseMap = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            String field = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LinkedHashMap) {
                fieldElement1 = fac.createOMElement(field, omNS);
                fieldElement1.addChild(recursiveMapRetrive((LinkedHashMap) value, fieldElement1));

            } else if (value instanceof ArrayList) {
                OMElement fieldElement = null;
                for (Object object : (ArrayList) value) {
                    if (object instanceof LinkedHashMap) {
                        fieldElement = fac.createOMElement(field, omNS);
                        fieldElement1.addChild(recursiveMapRetrive((LinkedHashMap) object,fieldElement));
                    } else {
                        fieldElement = fac.createOMElement(field, omNS);
                        fieldElement.addChild(fac.createOMText(fieldElement1,object.toString()));
                        fieldElement1.addChild(fieldElement);
                    }
                }
                return fieldElement1;
            } else {
                fieldElement1 = fac.createOMElement(field, omNS);
                fieldElement1.addChild(fac.createOMText(fieldElement1,value.toString()));
            }
            responseElement.addChild(fieldElement1);
        }
        return responseElement;
    }