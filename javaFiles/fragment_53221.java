try {
            FileInputStream is = new FileInputStream(new File("C:\\Desktop\\ook.xls"));
            HSSFWorkbook wb = new HSSFWorkbook(is);
            String str = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
            HSSFSheet sheet = wb.getSheet("Sheet1");

            Row row =  sheet.createRow(0);
            Cell cell = row.createCell(0);

                CellStyle style = wb.createCellStyle(); 
                style.setWrapText(true); 
                cell.setCellStyle(style); 
                cell.setCellValue(str);

            wb.write(new FileOutputStream(new File("C:\\Desktop\\ook.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }