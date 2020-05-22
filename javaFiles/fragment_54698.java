HSSFWorkbook wb = new HSSFWorkbook();
HSSFSheet sheet = wb.createSheet("Sheet1");
sheet = wb.getSheetAt(0);

for (Row myrow : sheet) {
    for (Cell mycell : myrow) {
        //set foreground color here
    }
}