Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(OUTPUT_FILE));
    document.open();
    PdfPTable table = new PdfPTable(4);

    CellMarginEvent cellMarginEvent = new CellMarginEvent();
    for (int aw = 0; aw < 320; aw++) {
        PdfPCell cell = new PdfPCell();
        cell.addElement(new Paragraph("Cell: " + aw));
        cell.setCellEvent(cellMarginEvent);
        table.addCell(cell);
    }