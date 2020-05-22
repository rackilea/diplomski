Workbook workbook = new XSSFWorkbook();
for(String key : yourMap.keySet()){
    Sheet sheet = workbook.createSheet(key);
    List<Integer> values = yourMap.get(key);
    int row = 0;
    for(Integer value : values){
        sheet.creatRow(row).createCell(0).setCellValue(value);
        row++;
    }
}