// Load your Excel file
Workbook wb = new Workbook(dirPath + "sort.xlsx");

// For the first key, we want to sort by assending order
// And we want to sort by row not by column
// using SortLeftToRight property
wb.getDataSorter().setOrder1(SortOrder.ASCENDING);
wb.getDataSorter().setSortLeftToRight(true);

// Access first worksheet
Worksheet ws = wb.getWorksheets().get(0);

// Specify the range of cells
CellArea ca = CellArea.createCellArea("A1", "I7");

// We want to sort by row 3, since index starts from 0
// So 2 means 3
wb.getDataSorter().setKey1(2);

// Sort the workbook data
wb.getDataSorter().sort(ws.getCells(), ca);

// Save the output Excel file
wb.save(dirPath + "output.xlsx");