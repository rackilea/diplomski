public File excelData() {

        File excel = new File("Somecrap.xls");

        OutputStream fos = null;

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();

        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderTop((short) 6); // double lines border
        style.setBorderBottom((short) 1); // single line border
        style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);

        HSSFFont font = workbook.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setFontHeightInPoints((short) 20);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.BLUE.index);
        //style.setFont(font);

        HSSFRow row = sheet.createRow(1);
        HSSFCell cell = row.createCell(1);
        cell.setCellValue(new HSSFRichTextString("Doing some excel crazy stuff!"));
        //cell.setCellStyle(style);
        sheet.autoSizeColumn((short) 1);

        fos = null;
        try {
            fos = new FileOutputStream(excel);
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return test;
    }

    public String excelFileName() {
        return "Somecrap.xls";
    }