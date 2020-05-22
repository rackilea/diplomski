for (Sheet sheet: workbook1.getSheets()) { // getSheet() returns a Sheet[]
 int numCols = sheet.getColumns(); // getColumns() returns an int
 for (
     for int i = 0; i <= numCols; i++) {
     Cell[] column = sheet.getColumn(i);
     for (Cell cell: column) { // column is a Cell[]
         if (cell.equals(saved[j])) {
             System.out.print(cell);
         }
     }
 }
}