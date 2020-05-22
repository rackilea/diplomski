Elements links = getLinkList();
XWPFDocument document = new XWPFDocument();   
XWPFParagraph tmpParagraph = document.createParagraph();  
for (Element link : links) {
  XWPFRun tmpRun = tmpParagraph.createRun();   
  tmpRun.setText(link.attr("href"));   
}