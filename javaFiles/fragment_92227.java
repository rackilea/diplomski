public static void main(String[] args) {
    Path myFile = Paths.get(System.getProperty("user.home"), "Desktop", "tester.xlsx");

        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(myFile.toFile()));
            XSSFSheet sheet = wb.getSheetAt(0);
            makeRowBold(wb, sheet.getRow(0));

            wb.write(new FileOutputStream(myFile.toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
}


public static void makeRowBold(Workbook wb, Row row){
    CellStyle style = wb.createCellStyle();//Create style
    Font font = wb.createFont();//Create font
    font.setBold(true);//Make font bold
    style.setFont(font);//set it to bold

    for(int i = 0; i < row.getLastCellNum(); i++){//For each cell in the row 
        row.getCell(i).setCellStyle(style);//Set the sty;e
    }
}