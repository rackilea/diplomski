XsltProcessor processor = new XsltProcessor();
processor.importStyleSheet(styleSheetText);
processor.importSource(sourceText);
processor.setParameter("ord", "2");
processor.setParameter("style", "whatever");
String resultString = processor.transform();
// do something with resultString