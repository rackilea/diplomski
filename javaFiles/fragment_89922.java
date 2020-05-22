// Main table
    PdfPTable mainTable = new PdfPTable(2);
    mainTable.setWidthPercentage(100.0f);

    // First table
    PdfPCell firstTableCell = new PdfPCell();
    firstTableCell.setBorder(PdfPCell.NO_BORDER);
    PdfPTable firstTable = new PdfPTable(2);
    //......... add some cells here ...........
    firstTableCell.addElement(firstTable);
    mainTable.addCell(firstTableCell);

    // Second table
    PdfPCell secondTableCell = new PdfPCell();
    secondTableCell.setBorder(PdfPCell.NO_BORDER);
    PdfPTable secondTable = new PdfPTable(2);
    //......... add some cells here ...........
    secondTableCell.addElement(secondTable);
    mainTable.addCell(secondTableCell);

    paragraph.add(mainTable);
    document.add(paragraph);