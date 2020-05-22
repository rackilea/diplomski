//create new workbook
XSSFWorkbook workbook = new XSSFWorkbook(); 

//create spreadsheet with a name
XSSFSheet spreadsheet = workbook.createSheet("new sheet");

//create first row on a created spreadsheet
XSSFRow row = spreadsheet.createRow(0);

//create first cell on created row
XSSFCell cell = row.createCell(0);