Workbook existingWorkbook = Workbook.getWorkbook(new File(filename1));
WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(filename1), existingWorkbook);
WritableSheet sheetToEdit = workbookCopy.getSheet(0);

for (int i=0; i<sheetToEdit.getcolumns(); i++) {
    int columnCount = 0;
    for (Cell cell : sheetToEdit.getColumn(i))
        if (!cell.getContents().equals(""))
            columnCount++;
    System.out.println(columnCount);
}

workbookCopy.write();
workbookCopy.close();