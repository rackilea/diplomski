Document pdfDocument = new Document(); 
    Page pdfPage = (Page) pdfDocument.getPages().add();

    Table table = new Table();
    table.setColumnAdjustment(ColumnAdjustment.AutoFitToWindow);

    table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.1F));
    table.setColumnWidths("150 150 150 150 150");
    table.setMargin(new MarginInfo(50, 50, 50, 50));

    Row headerRow1 = table.getRows().add();
    headerRow1.setFixedRowHeight(100);
    Cell headerCell1 = headerRow1.getCells().add();

    TextFragment headerText201 = new TextFragment("मालकाचे नाव  ");
    headerText201.getTextState().setFontSize(8.0F);
    headerText201.getTextState().setRotation(90);
    headerCell1.getParagraphs().add(headerText201);
    headerCell1.getDefaultCellTextState().setHorizontalAlignment(HorizontalAlignment.Center);

    Paragraphs paragraphs = pdfPage.getParagraphs();
    paragraphs.add(table);

    pdfDocument.save(StringConstants.REPORT_PATH + "TextFragmentTests_Rotated.pdf");