...
  // Cells which join (merge) the first one, must be removed
  for(int colIndex = toCol; colIndex > fromCol; colIndex--) {
   table.getRow(row).getCtRow().removeTc(colIndex);
   table.getRow(row).removeCell(colIndex);
  }
...