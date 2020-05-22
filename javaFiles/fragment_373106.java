Document document = Document.parse(jsonString);

Document newDocument = Document.parse(document.toJson()).append("status","processing");

System.out.println(newDocument);
System.out.println(document);