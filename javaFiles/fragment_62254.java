String inPath = "/home/elmicha/test/template.xlsx";
String outPath = "/home/elmicha/test/out.xlsx";

try (Workbook xlsxFile = WorkbookFactory.create(new FileInputStream(inPath))) {
    xlsxFile.getSheetAt(0).createRow(0).createCell(0).setCellValue("test");

    try (FileOutputStream pOuts = new FileOutputStream(outPath)) {
        xlsxFile.write(pOuts);
    }

} catch (IOException | InvalidFormatException | EncryptedDocumentException ex) {
    //...
}