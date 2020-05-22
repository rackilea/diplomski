if (isShaded) {
    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    if (color.equalsIgnoreCase("yellow")){
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
    }
    else if (color.equalsIgnoreCase("light grey")){
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
    }
}