File file = new File("phone_compare.xlsx");
    FileInputStream fs = new FileInputStream(file);

    XSSFWorkbook wb=new XSSFWorkbook(fs);
    String min = wb.getSheetAt(0).getRow(0).getCell(1).getStringCellValue();
    int value_min = Integer.parseInt(min.substring(1).replace(",", ""));

    String getText = null;

    String str1 =  wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
    String str2 =  wb.getSheetAt(0).getRow(0).getCell(2).getStringCellValue();
    getText = str1 +" " +value_min +" " +str2;
    XSSFSheet sh1= wb.getSheetAt(0);


    for (int i = 0; i <=sh1.getLastRowNum(); i++) {

        String c =  wb.getSheetAt(0).getRow(i).getCell(1).getStringCellValue();

        int value = Integer.parseInt(c.substring(1).replace(",", ""));

        if(value < value_min) {
            value_min=value;
            str1 =  wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue();
            str2 =  wb.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();
            getText = str1 +" " +value_min +" " +str2;



    }

}    
System.out.println(getText);
}