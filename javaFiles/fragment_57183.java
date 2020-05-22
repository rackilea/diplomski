cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1257,BaseFont.EMBEDDED), 10); 
cb.beginText(); 
cb.resetRGBColorStroke();
cb.setTextMatrix(320, 420); 
cb.showText("Text inside cd");

ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,new Phrase("Hello itext"),50, 700, 0);
cb.endText();