final Table.TableBuilder tableHeaderBuilder = Table.builder()
        .addColumnOfWidth(200)
        .addColumnOfWidth(200);

CellText dummyHeaderCell = CellText.builder()
        .text("Header dummy")
        .backgroundColor(Color.BLUE)
        .textColor(Color.WHITE)
        .borderWidth(1F)
        .build();

tableHeaderBuilder.addRow(
        Row.builder()
                .add(dummyHeaderCell)
                .add(dummyHeaderCell)
                .build());

Table tableHeader = tableHeaderBuilder.build();

final Table.TableBuilder tableBuilder = Table.builder()
        .addColumnOfWidth(200)
        .addColumnOfWidth(200);

CellText dummyCell = CellText.builder()
        .text("dummy")
        .borderWidth(1F)
        .build();

for (int i = 0; i < 50; i++) {
    tableBuilder.addRow(
            Row.builder()
                    .add(dummyCell)
                    .add(dummyCell)
                    .build());
}

TableDrawer drawer = TableDrawer.builder()
        .table(tableBuilder.build())
        .startX(50)
        .endY(50F) // note: if not set, table is drawn over the end of the page
        .build();

final PDDocument document = new PDDocument();

float startY = 100F;

do {
    TableDrawer headerDrawer = TableDrawer.builder()
            .table(tableHeader)
            .startX(50)
            .build();

    PDPage page = new PDPage(PDRectangle.A4);
    document.addPage(page);
    try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
        headerDrawer.startY(startY);
        headerDrawer.contentStream(contentStream).draw();
        drawer.startY(startY - tableHeader.getHeight());
        drawer.contentStream(contentStream).draw();
    }

    startY = page.getMediaBox().getHeight() - 50;
} while (!drawer.isFinished());

document.save("twoPageTable-repeatingHeader.pdf");
document.close();