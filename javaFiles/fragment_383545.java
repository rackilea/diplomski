try (PdfDocument doc = new PdfDocument(new PdfReader(in.toFile()), new PdfWriter(out.toFile()))) {
    PdfFont helvetica = PdfFontFactory.createFont();
    for (int pageNum = 1; pageNum <= doc.getNumberOfPages(); pageNum++) {
        PdfPage page = doc.getPage(pageNum);
        // important - add a new content stream in the beginning, to render behind existing text
        PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), doc);

        // option 1 - manual placement
        canvas.saveState();
        canvas.beginText();
        canvas.setFillColor(ColorConstants.GRAY);
        canvas.setFontAndSize(helvetica, 80f);
        canvas.moveText(0f, page.getPageSize().getHeight() - 80f);
        canvas.showText("Confidential1");
        canvas.endText();
        canvas.restoreState();

        // option 2 - let iText place it
        try (Canvas canvas1 = new Canvas(canvas, doc, page.getPageSize())) {
            Paragraph watermark = new Paragraph("Confidential2")
                    .setFontColor(ColorConstants.GRAY)
                    .setFont(helvetica)
                    .setFontSize(80f)
                    .setHorizontalAlignment(HorizontalAlignment.LEFT)
                    .setVerticalAlignment(VerticalAlignment.BOTTOM)
                    .setFixedPosition(0f, page.getPageSize().getHeight() - 100f, page.getPageSize().getWidth());
            canvas1.add(watermark);
        }

        // option 3 - set opacity and place on top of existing content, plus rotation
        PdfExtGState gstate = new PdfExtGState();
        gstate.setFillOpacity(.2f);
        canvas = new PdfCanvas(page);
        canvas.saveState();
        canvas.setExtGState(gstate);
        try (Canvas canvas2 = new Canvas(canvas, doc, page.getPageSize())) {
            double rotationDeg = -54.7d;
            double rotationRad = Math.toRadians(rotationDeg);
            Paragraph watermark = new Paragraph("Confidential3")
                    .setFont(helvetica)
                    .setFontSize(80f)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setRotationAngle(rotationRad)
                    .setFixedPosition(100, page.getPageSize().getHeight(), page.getPageSize().getWidth());
            canvas2.add(watermark);
        }
        canvas.restoreState();
    }
}