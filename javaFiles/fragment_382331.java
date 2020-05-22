ITextRenderer renderer = new ITextRenderer();
renderer.getFontResolver().addFont("font/DEJAVUSANS.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

renderer.setDocument(url); 
renderer.layout();
renderer.createPDF(os);