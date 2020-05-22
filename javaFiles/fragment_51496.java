Sheet sheet = null;
try {

    Workbook workbook = WorkbookFactory.create(inputFS);
    sheet = workbook.getSheetAt(0);
}
catch (Exception e) {
}