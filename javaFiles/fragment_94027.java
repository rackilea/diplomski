XWPFDocument document = new XWPFDocument();
XWPFParagraph tmpParagraph = document.createParagraph();
XWPFRun tmpRun = tmpParagraph.createRun();
tmpRun.setText("LALALALAALALAAAA");
tmpRun.setFontSize(18);
document.write(new FileOutputStream(new File("yourpathhere")));
document.close();