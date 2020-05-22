// to store all the records
List<HashMap> records = new ArrayList<HashMap>();
Workbook workbook = Workbook.getWorkbook(new File("C:/promocoes.xls"));
Sheet sheet = workbook.getSheet(0);  
int rowCount = sheet.getRows();
for(int i = 0; i < rowCount; i++){
    HashMap<String, String> record = new HashMap<String, String>();
    record.put("nomepromocao", sheet.getCell(0, i).getContents());
    record.put("tipopromocao", sheet.getCell(1, i).getContents());
    records.add(record);      
}
workbook.close();

// to iterate each record
for(HashMap<String, String> record : records){

    driver.findElement(By.name("nomePromocao"))
          .sendKeys(record.get("nomepromocao"));

    driver.findElement(By.name("descPromocao"))
          .sendKeys(record.get("descPromocao"));

}