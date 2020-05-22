public class CopyXSSFWorkbook {

    public static void main(String[] args) {

        // Read xlsx file
        XSSFWorkbook oldWorkbook = null;
        try {
            oldWorkbook = (XSSFWorkbook) WorkbookFactory.create(new File("old.xlsx"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        final XSSFWorkbook newWorkbook = new XSSFWorkbook();

        // Copy style source
        final StylesTable oldStylesSource = oldWorkbook.getStylesSource();
        final StylesTable newStylesSource = newWorkbook.getStylesSource();

        oldStylesSource.getFonts().forEach(font -> newStylesSource.putFont(font, true));
        oldStylesSource.getFills().forEach(fill -> newStylesSource.putFill(new XSSFCellFill(fill.getCTFill())));
        oldStylesSource.getBorders()
                .forEach(border -> newStylesSource.putBorder(new XSSFCellBorder(border.getCTBorder())));

        // Copy sheets
        for (int sheetNumber = 0; sheetNumber < oldWorkbook.getNumberOfSheets(); sheetNumber++) {
            final XSSFSheet oldSheet = oldWorkbook.getSheetAt(sheetNumber);
            final XSSFSheet newSheet = newWorkbook.createSheet(oldSheet.getSheetName());

            newSheet.setDefaultRowHeight(oldSheet.getDefaultRowHeight());
            newSheet.setDefaultColumnWidth(oldSheet.getDefaultColumnWidth());

            // Copy content
            for (int rowNumber = oldSheet.getFirstRowNum(); rowNumber < oldSheet.getLastRowNum(); rowNumber++) {
                final XSSFRow oldRow = oldSheet.getRow(rowNumber);
                if (oldRow != null) {
                    final XSSFRow newRow = newSheet.createRow(rowNumber);
                    newRow.setHeight(oldRow.getHeight());

                    for (int columnNumber = oldRow.getFirstCellNum(); columnNumber < oldRow
                            .getLastCellNum(); columnNumber++) {
                        newSheet.setColumnWidth(columnNumber, oldSheet.getColumnWidth(columnNumber));

                        final XSSFCell oldCell = oldRow.getCell(columnNumber);
                        if (oldCell != null) {
                            final XSSFCell newCell = newRow.createCell(columnNumber);

                            // Copy value
                            setCellValue(newCell, getCellValue(oldCell));

                            // Copy style
                            XSSFCellStyle newCellStyle = newWorkbook.createCellStyle();
                            newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
                            newCell.setCellStyle(newCellStyle);
                        }
                    }
                }
            }
        }

        try {
            oldWorkbook.close();
            newWorkbook.write(new FileOutputStream("new.xlsx"));
            newWorkbook.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static void setCellValue(final XSSFCell cell, final Object value) {
        if (value instanceof Boolean) {
            cell.setCellValue((boolean) value);
        } else if (value instanceof Byte) {
            cell.setCellValue((byte) value);
        } else if (value instanceof Double) {
            cell.setCellValue((double) value);
        } else if (value instanceof String) {
            if (value.startsWith("=")) { 
                //  Formula String  
                cell.setCellFormula(value.substring(1));
            } else {
                cell.setCellValue(cstr);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static Object getCellValue(final XSSFCell cell) {
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                return cell.getBooleanCellValue(); // boolean
            case ERROR:
                return cell.getErrorCellValue(); // byte
            case NUMERIC:
                return cell.getNumericCellValue(); // double
            case STRING:
            case BLANK:
                return cell.getStringCellValue(); // String
            case FORMULA:
                return  "=" + cell.getCellFormula(); // String for formula
            default:
                throw new IllegalArgumentException();
        }
    }
}