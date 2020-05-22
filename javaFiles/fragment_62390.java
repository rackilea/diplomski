HeaderFooter header = new HeaderFooter(new Phrase("HBOM Reports"), false);
header.setAlignment(HeaderFooter.ALIGN_CENTER);
header.setBorder(Rectangle.NO_BORDER); 
header.setBorder(Rectangle.BOTTOM);
document.setHeader(header);

HeaderFooter footer = new HeaderFooter(new Phrase("globematics\nSecond line"), false);
footer.setAlignment(HeaderFooter.ALIGN_CENTER);
footer.setBorder(Rectangle.NO_BORDER); 
footer.setBorder(Rectangle.TOP);
document.setFooter(footer);