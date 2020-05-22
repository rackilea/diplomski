// this actually creates a DocExtractorDoc object (but you don't care)
DocExtractor de1 = DocExtractorFactory.create(new File("myDocFile.doc"));
// this actually uses DocExtractorDoc.getText (but again you don't care)
String s1 = de1.getText();
// this actually creates a DocExtractorXls object
DocExtractor de2 = DocExtractorFactory.create(new File("myDocFile.xls"));
// this actually uses DocExtractorXls.getText
String s2 = de2.getText();