// Get the cell we want to find - A1 for this case
Workbook wb = WorkbookFactory.create("input.xlsx");
int sheetIndex = 0;
Sheet s = wb.getSheetAt(sheetIndex);
Cell wanted = s.getRow(0).getCell(0);
String wantedRef = (new CellReference(wanted)).formatAsString();

// Check all the named range
for (int nn=0; nn<wb.getNumberOfNames(); nn++) {
   Name n = wb.getNameAt(nn);
   if (n.getSheetIndex() == -1 || n.getSheetIndex() == sheetIndex) {
      if (n.getRefersToFormula().equals(wantedRef)) {
         // Found it!
         return name.getNameName();
      }
   }
}