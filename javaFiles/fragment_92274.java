List<Map<String, String>> rowForSheet = new ArrayList<Map<String, String>>();
for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {

   row = sheet.getRow(j);
   if (j == 0) {// the first row is title
      titleRow = row;
      continue;
   }
   Map<String, String> cellForRow = = new HashMap<String, String>();
   if (row != null && titleRow.getPhysicalNumberOfCells() > 0) {
       for (int k = 0; k < titleRow.getPhysicalNumberOfCells(); k++) {// cell
           cellForRow.put(
               getCellValue(titleRow.getCell(k)), 
               getCellValue(row.getCell(k))
           );
       }
   }
   rowForSheet.add(cellForRow);
}