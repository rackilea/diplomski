SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();

// Condition 1: Formula Is   =SUM($M2+$N2+$O2+$P2) > 75   
ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule("SUM($M2+$N2+$O2+$P2)>75");

PatternFormatting fill1 = rule1.createPatternFormatting();

fill1.setFillBackgroundColor(IndexedColors.RED.index);
fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

CellRangeAddress[] regions = {
    CellRangeAddress.valueOf("L2:L5")
};

sheetCF.addConditionalFormatting(regions, rule1);