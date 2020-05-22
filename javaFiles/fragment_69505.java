Workbook wb = new XSSFWorkbook();
    Sheet s = wb.createSheet();

    // Create some cells, some numeric, some not
    Cell c1 = s.createRow(0).createCell(0);
    Cell c2 = s.getRow(0).createCell(1);
    Cell c3 = s.getRow(0).createCell(2);
    Cell c4 = s.createRow(1).createCell(0);
    Cell c5 = s.getRow(1).createCell(1);
    Cell c6 = s.getRow(1).createCell(2);
    c1.setCellValue(12);
    c2.setCellValue(34.56);
    c3.setCellValue("ABCD");
    c4.setCellValue("AB");
    c5.setCellValue("CD");
    c6.setCellValue("EF");

    // Setting up the CTTable
    Table t = s.createTable();
    t.setName("TableTest");
    t.setDisplayName("CT_Table_Test");
    t.addColumn();
    t.addColumn();
    t.addColumn();
    t.setCellReferences(new AreaReference(
            new CellReference(c1), new CellReference(c6)
    ));