Sheet sheet = null;
try {

    POIFSFileSystem poifs = new POIFSFileSystem(inputFS);
    Workbook workbook = new HSSFWorkbook(poifs);
    sheet = workbook.getSheetAt(0);
}
catch (Exception e) {
}

if (sheet == null) {

    try {

        Workbook workbook = new XSSFWorkbook(inputFS);
        sheet = workbook.getSheetAt(0);
    }
    catch (Exception e) {
    }
}