PdfWriter writer = ...;
PdfContentByte cb = writer.getDirectContent();
cb.saveState();
cb.setColorStroke(Color.black);
cb.rectangle(x,y,x1,y1);
cb.stroke();
cb.restoreState();