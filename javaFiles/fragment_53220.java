try {
        FileInputStream is = new FileInputStream(new File("C:\\Desktop\\ook.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(is);
        String str = "111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        HSSFSheet sheet = wb.getSheet("Sheet1");

        Row row =  sheet.createRow(0);
        Cell cell = row.createCell(0);
        Cell cell1 = row.createCell(1);

            CellStyle style = wb.createCellStyle(); 

            cell.setCellStyle(style); 
            cell.setCellValue(str); 

            CellStyle style2 = wb.createCellStyle(); 
            cell1.setCellStyle(style2); 
            cell1.setCellValue(str); 

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

        wb.write(new FileOutputStream(new File("C:\\Desktop\\ook.xls")));
    } catch (IOException e) {
        e.printStackTrace();
    }