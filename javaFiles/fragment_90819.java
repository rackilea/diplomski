public void arraysSigmaMatrices() throws FileNotFoundException, IOException {
    for(int catrgory = 0; catrgory < excelSheets.length; catrgory++) {
        try (FileInputStream input = new FileInputStream(excelSheets[catrgory])) {
            HSSFWorkbook workbook=new HSSFWorkbook(input);//to be able to create everything in the excel sheet
        }
        for(int ngauss = 0; ngauss < 30; ngauss++){
            String sheetname="Sigma"+(String.valueOf(ngauss+1));//adding the index to the sheet name
            HSSFSheet sheet=workbook.getSheet(sheetname);//getting the sheet
            for(int row= 0; row < 13; row++) {
                HSSFRow rows=sheet.getRow(row);
                for(int column= 0; column < 13; column++) {
                    arraysSigmaMatrices[catrgory][ngauss][row][column]=rows.getCell(column).getNumericCellValue();
                }
            }
        }           
    }
}