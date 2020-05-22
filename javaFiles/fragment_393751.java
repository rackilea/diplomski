ByteArrayOutputStream expected = new ByteArrayOutputStream();
storeXml(expectedDocument, expected);

ByteArrayOutputStream actual = new ByteArrayOutputStream();
storeXml(actualDocument, actual);

assertXMLEqual(expected.toString(), actual.toString());