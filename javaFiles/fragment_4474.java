Workbook wb1 = WorkbookFactory.create(new FileInputStream("myXlsFile.xls"));
Workbook wb2 = WorkbookFactory.create(new FileInputStream("myXlsxFile.xlsx"));
// this prints "wb1 class = org.apache.poi.xssf.usermodel.XSSFWorkbook"
System.out.println("wb1 class = " + wb1.getClass().getName());
// this prints "wb2 class = org.apache.poi.hssf.usermodel.HSSFWorkbook"
System.out.println("wb2 class = " + wb2.getClass().getName());