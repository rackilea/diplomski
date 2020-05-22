ConditionalFormattingRule red = sheetCF.createConditionalFormattingRule(
    "MOD(ROW() - 1, 10) < 5");
FontFormatting ffRed = red.createFontFormatting();
ffRed.setFontColorIndex(IndexedColors.RED.index);

ConditionalFormattingRule blue = sheetCF.createConditionalFormattingRule(
    "MOD(ROW() - 1, 10) >= 5");
FontFormatting ffBlue = blue.createFontFormatting();
ffBlue.setFontColorIndex(IndexedColors.BLUE.index);