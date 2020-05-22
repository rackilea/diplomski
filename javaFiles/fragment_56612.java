PdfContentByte canvas = resultandPdfStamper.getOverContent(1);
Rectangle pageSize = resultantPdfReader.getPageSize(1);
PdfPatternPainter painter = canvas.createPattern(pageSize.getWidth(), pageSize.getHeight());
painter.addImage(image);
canvas.setColorFill(new PatternColor(painter));
canvas.rectangle(0, 0, pageSize.getWidth(), pageSize.getHeight());
canvas.fill();