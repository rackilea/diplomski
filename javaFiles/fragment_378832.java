Workbook workbook = Workbook.getWorkbook(new File("C:/promocoes.xls"));
Sheet sheet = workbook.getSheet(0);  
int rowCount = sheet.getRows();
for(int i = 0; i < rowCount; i++){
    String nomePromocao = sheet.getCell(0, i).getContents();
    String descPromocao = sheet.getCell(1, i).getContents();

    driver.findElement(By.name("nomePromocao"))
          .sendKeys(nomePromocao);

    driver.findElement(By.name("descPromocao"))
          .sendKeys(descPromocao); 
}
workbook.close();