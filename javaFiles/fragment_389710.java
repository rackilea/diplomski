PDDocument doc = new PDDocument();
    PDPage pdpage = new PDPage();
    doc.addPage(pdpage);
    PDPageContentStream stream = new PDPageContentStream(doc, pdpage, false, false);

    // move stuff a bit up and right
    stream.concatenate2CTM(AffineTransform.getTranslateInstance(100, 400));

    stream.setStrokingColorSpace(PDDeviceRGB.INSTANCE);
    stream.setStrokingColor(Color.red);
    stream.setLineWidth(10f);
    stream.moveTo(1, 1);
    stream.addBezier32(111, 075, 200, 200);
    stream.addBezier32(352, 124, 80, 80);
    stream.addBezier32(432, 333, 300, 333);
    stream.stroke();

    stream.close();
    doc.save(filename);
    doc.close();