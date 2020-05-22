Chapter chapter = new Chapter(new Paragraph("Table \n\n"), 0);
// prepare chapter to be set piecewise
chapter.setComplete(false);
chapter.setNumberDepth(0);
chapter.add(new Paragraph("   "));
for (int i = 1; i < 5; i++) {

    float[] columnWidths = { 1f, 1f };
    // create PDF table with the given widths
    PdfPTable table = new PdfPTable(columnWidths);
    table.setHorizontalAlignment(Element.ALIGN_LEFT);
    table.setWidthPercentage(30.0f);
    // add recent chapter additions
    document.add(chapter);
    Section subsection = chapter.addSection(new Paragraph("Table "+i+" \n\n"), 0);
    event.setTableName("Table header" + i);
    writer.setPageEvent(event);
    table.addCell(new PdfPCell(new Phrase("Column 1", font)));
    table.addCell(new PdfPCell(new Phrase("Column 2", font)));
    table.setHeaderRows(1);
    for (int j = 0; j < 25; j++) {
        table.addCell(new PdfPCell(new Phrase("Hello" + j, font)));
        table.addCell(new PdfPCell(new Phrase("World" + j, font)));
    }
    subsection.add(table);
    subsection.newPage();

}
// prepare chapter to be completed
chapter.setComplete(true);
// final adding of chapter
document.add(chapter);