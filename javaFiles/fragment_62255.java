String inPath = "/home/elmicha/test/template.xlsx";
String outPath = "/home/elmicha/test/out.xlsx";

try (Workbook xlsxFile = WorkbookFactory.create(new FileInputStream(inPath));
    FileOutputStream pOuts = new FileOutputStream(outPath)) {

    xlsxFile.getSheetAt(0).createRow(0).createCell(0).setCellValue("test");
    xlsxFile.write(pOuts);


} catch (IOException | InvalidFormatException | EncryptedDocumentException ex) {
    //...
}