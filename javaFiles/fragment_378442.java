public static HSSFRow findRow(String stringToFind){
            //`hswb` is HSSFWorkbook
    HSSFSheet sheet = hswb.getSheetAt(0);
    Iterator <Row> rowItr = sheet.iterator();
    while(rowItr.hasNext()){
        HSSFRow row = (HSSFRow) rowItr.next();
        if(row.getCell(0).toString().equalsIgnoreCase(stringToFind)){
            return row;
        }
    }
  // If no such row found need to handle NullPointerException for that
    return null;
}