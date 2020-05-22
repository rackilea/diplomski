File src = new File("C:\\selenium\\ExcelData\\TestData.xlsx");
    FileInputStream fis = new FileInputStream(src);
    wb = new XSSFWorkbook(fis);
    XSSFSheet sh1 = wb.getSheet(getName);

    String getValue = null;
    String value = null;
    int number=sh1.getLastRowNum()+1;
    System.out.println("Total used rows :" + number);
    for (int i = 1; i<number; i++) {
        if(sh1.getRow(i).getCell(0) != null)
        {
             getValue = sh1.getRow(i).getCell(0).getStringCellValue();
        }

        if(getValue != null) {
            if(!getValue.contains(getName)) {
                if(sh1.getRow(i).getCell(1) != null)
                {
                     value = sh1.getRow(i).getCell(1).getStringCellValue();
                }
                System.out.println(value);
                fis.close();
                break;
            }   
        }   

    }
    return value;



}