public CellRangeAddress getMergedRegionForCell(Cell c) {
   Sheet s = c.getRow().getSheet();
   for (CellRangeAddress mergedRegion : s.getMergedRegions()) {
      if (mergedRegion.isInRange(c.getRowIndex(), c.getColumnIndex())) {
         // This region contains the cell in question
         return mergedRegion;
      }
   }
   // Not in any
   return null;
}