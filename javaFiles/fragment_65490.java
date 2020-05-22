private HSSFFont setFontColor(HSSFWorkbook wb, HSSFFont font, String colorCode) {
    HSSFPalette palette = wb.getCustomPalette();

    // if format is rgb(x,y,z) form, retrieve the 3 numbers within the
    // parentheses
    colorCode = colorCode.trim();
    if (colorCode.toLowerCase().startsWith("rgb")) {
        String rgbNumString = colorCode.substring(3, colorCode.length()).trim();
        rgbNumString = rgbNumString.substring(1, rgbNumString.length()-1).trim();
        String[] rgbNums = StringUtils.split(rgbNumString, ",");
        int[] rgbInts = { Integer.parseInt(rgbNums[0].trim()),
                Integer.parseInt(rgbNums[1].trim()),
                Integer.parseInt(rgbNums[2].trim()) };
        HSSFColor color = palette.findSimilarColor(rgbInts[0], rgbInts[1], rgbInts[2]);
        short palIndex = color.getIndex();
        font.setColor(palIndex);
        return font;
    } 
    return font;
}