...
 final Element element = doc.getDocumentElement(); // original code up to here

 traversingXML(element); // delete the node

 writeXmlFile(doc, "LSA_SALES_EXPORT_1507_test_zero_qu_OUT.xml"); // save modified document