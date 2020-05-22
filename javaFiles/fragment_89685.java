private int red;
private int green;
private int blue;

public void loadRgb(XSSFWorkbook table, XSSFCellStyle variableStyle) {
   long fillId = variableStyle.getCoreXf().getFillId();
   StylesTable stylesSource = table.getStylesSource();
   XSSFCellFill fill = stylesSource.getFillAt((int) fillId);
   CTColor fgColor = fill.getCTFill().getPatternFill().getFgColor();
   if (fgColor != null) {
      if (fgColor.xgetRgb() != null) {
         convert(fgColor.xgetRgb().getStringValue());
      } else {
         convert(stylesSource.getTheme().getThemeColor((int) fgColor.getTheme()).getRgb());
      }
   }
}

private void convert(String stringValue) {
   // the string value contains an alpha value, so we skip the first 2 chars
   red = Integer.valueOf(stringValue.substring(2, 4), 16).intValue();
   green = Integer.valueOf(stringValue.substring(4, 6), 16).intValue();
   blue = Integer.valueOf(stringValue.substring(6, 8), 16).intValue();
}

private void convert(byte[] rgb) {
   if (rgb != null) {
      // Bytes are signed, so values of 128+ are negative!
      // 0: red, 1: green, 2: blue
      red = (rgb[0] < 0) ? (rgb[0] + 256) : rgb[0];
      green = (rgb[1] < 0) ? (rgb[1] + 256) : rgb[1];
      blue = (rgb[2] < 0) ? (rgb[2] + 256) : rgb[2];
   }
}