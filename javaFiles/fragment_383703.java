HSSFConditionalFormatting mycf = new_hire.getSheetConditionalFormatting();
for(int x=4; x<500; x++) {
    HSSFRow row = new_hire.getRow(x);
    if(null == row) {
        row = new_hire.createRow(x);
    }
    HSSFCell cell = row.getCell(0); // 0 for column A
    if(null == cell) {
        cell = row.createCell(0);
    }
    String cellId = "A"+(x+1);
    CellRangeAddress[] range = new CellRangeAddress(x, x, 0, 0); // 0 for column A
    HSSFConditionalFormattingRule rule = highlightIfMatch(mycf, cellId);
    range.addConditionalFormatting(range, rule);
}