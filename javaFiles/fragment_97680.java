//p is the XWPFParagraph
for (XWPFRun pRun : p.getRuns()) {
   CTRPr ctrpr = pRun.getCTR().getRPr();
   if (ctrpr != null && ctrpr.isSetHighlight()) { 
      //This is highlighted
   }
}