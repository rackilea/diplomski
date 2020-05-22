XSSFConditionalFormattingRule rule = sheet.getSheetConditionalFormatting().createConditionalFormattingRule("MOD(ROW(), 2) = 0");
XSSFPatternFormatting fill = rule.createPatternFormatting();
fill.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
fill.setFillPattern(FillPatternType.SOLID_FOREGROUND.getCode());
CellRangeAddress[] regions = { CellRangeAddress.valueOf("A2:Z" + (sheet.getLastRowNum() + 1)) };

sheet.getSheetConditionalFormatting().addConditionalFormatting(regions, rule);