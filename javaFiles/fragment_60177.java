...

//ERROR CODE:
//StreamResult result = new StreamResult(new File(xmlPath, "subcompany.xml"));
//
StreamResult result = new StreamResult(new File(xmlPath, "subcompany.xml").getPath());
transformer.transform(source, result);

...