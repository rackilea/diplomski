public static void makeRowBold(Workbook wb, Row row){
    CellStyle style = wb.createCellStyle();//Create style
    Font font = wb.createFont();//Create font
    font.setBold(true);//Make font bold
    style.setFont(font);//set it to bold

    for(int i = 0; i < row.getLastCellNum(); i++){//For each cell in the row 
        row.getCell(i).setCellStyle(style);//Set the style
    }
}