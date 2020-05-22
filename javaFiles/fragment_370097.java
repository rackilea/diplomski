List<Double> values = new ArrayList<Double>();
for(Row r : sheet) {
   Cell c = r.getCell(columnNumber);
   if(c != null) {
      if(c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
         valuesadd(c.getNumericCellValue());
      } else if(c.getCellType() == Cell.CELL_TYPE_FORMULA && c.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC) {
         valuesadd(c.getNumericCellValue());
      }
   }
}