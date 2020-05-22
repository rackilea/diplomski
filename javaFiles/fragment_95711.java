public class SO{
    public static void main(String[] args) {

        try {
            FileInputStream is = new FileInputStream(new File("D:\\Users\\user2777005\\Desktop\\bob.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(is);
            String header = "123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789";
            Sheet sheet = wb.getSheet("Sheet1");
            sheet.setColumnWidth(0, 18000);
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);

            if(header.length() > 50){ //Length of String for my test
                sheet.setColumnWidth(0, 18000); //Set column width, you'll probably want to tweak the second int
                CellStyle style = wb.createCellStyle(); //Create new style
                style.setWrapText(true); //Set wordwrap
                cell.setCellStyle(style); //Apply style to cell
                cell.setCellValue(header); //Write header
            }

            wb.write(new FileOutputStream(new File("D:\\Users\\user2777005\\Desktop\\bob.xlsx")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}