final StylesTable sourceStylesSource = sourceWorkbook.getStylesSource();
final StylesTable tagetStylesSource = targetWorkbook.getStylesSource();

sourceStylesSource.getFonts().forEach(font -> targetStylesSource.putFont(font, true));
sourceStylesSource.getFills().forEach(fill -> targetStylesSource.putFill(new XSSFCellFill(fill.getCTFill())));
sourceStylesSource.getBorders().forEach(border -> targetStylesSource.putBorder(new XSSFCellBorder(border.getCTBorder())));