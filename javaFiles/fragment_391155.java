XWPFDocument doc = new XWPFDocument(OPCPackage.open("test.docx"));
if (doc.getDocument().getBackground() == null) {
   doc.getDocument.addNewBackground();
};

CTBackground bkgnd = doc.getDocument().getBackground();
bkgnd.setColor("FFFFFF");