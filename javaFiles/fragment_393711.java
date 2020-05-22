PdfContentByte canvas = writer.getDirectContent();

PdfPatternPainter square = canvas.createPattern(15, 15);
square.setColorFill(new BaseColor(0xFF, 0xFF, 0x00));
square.setColorStroke(new BaseColor(0xFF, 0x00, 0x00));
square.rectangle(5, 5, 5, 5);
square.fillStroke();