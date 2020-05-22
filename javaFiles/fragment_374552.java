XmlCursor cursor= targetObject.newCursor();
cursor.toNextToken();
cursor.insertNamespace("A", "namespace1");
//For example
cursor.insertNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
cursor.dispose();