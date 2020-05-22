Map<String, Integer> map = new HashMap<String,Integer>(); //Create map
HSSFRow row = sheet.getRow(0); //Get first row
//following is boilerplate from the java doc
short minColIx = row.getFirstCellNum(); //get the first column index for a row
short maxColIx = row.getLastCellNum(); //get the last column index for a row
for(short colIx=minColIx; colIx<maxColIx; colIx++) { //loop from first to last index
   HSSFCell cell = row.getCell(colIx); //get the cell
   map.put(cell.getStringCellValue(),cell.getColumnIndex()) //add the cell contents (name of column) and cell index to the map
 }