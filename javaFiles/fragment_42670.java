Iterator<Row> rowIterator = spreadsheet.rowIterator();
while (rowIterator.hasNext()) {
    Row row = rowIterator.next();
    Cell dncReasonCell = row.getCell(1);
    if (dncReasonCell == null) {
        dncReasonCell = row.createCell(1, CellType.STRING);
    }
    Cell manufacturerCell = row.getCell(0);
    String manufacturerNameForDncTest = Pattern
            .compile("[\\.$|,|;|'|\\s|-]|\\b(LLC|Company|Incorporated|Co|Manufacturer|The|Limited|Ltd|Inc)\\b", Pattern.CASE_INSENSITIVE)
            .matcher(manufacturerCell.getStringCellValue()).replaceAll("");
    if (notToBeContactedManufacturers.containsKey(manufacturerNameForDncTest)) {
        manufacturerCell.setCellStyle(style);
        dncReasonCell.setCellValue(notToBeContactedManufacturers.get(manufacturerNameForDncTest).getDNCReason());
    } else {
        dncReasonCell.setCellValue("");
    }
}