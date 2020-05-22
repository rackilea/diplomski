public class App {

LinkedHashMap<String, String> map = new LinkedHashMap<>();

public static void main(String[] args) throws IOException {

    final App app = new App();

    for (final Locale locale : Locale.values()) {

        app.readExcelFile("locales_" + locale + ".xlsx");

        app.writeToPropertiesFile("messages_" + locale.name().substring(0, 2).toLowerCase() + ".properties");

    }

}

public void writeToPropertiesFile(String propertiesPath) throws IOException {

    final LinkedProperties props = new LinkedProperties();

    map.entrySet().forEach(entry -> props.setProperty(entry.getKey(), entry.getValue()));

    props.store(new FileOutputStream(new File(propertiesPath)), null);

}

public void readExcelFile(String fileName) throws IOException {

    Workbook workbook = null;

    XSSFCell cell1 = null;

    XSSFCell cell2 = null;

    try {

        workbook = WorkbookFactory.create(new File(fileName));

        final XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);

        final Iterator<Row> rowIterator = sheet.rowIterator();

        // skip first row which is header
        rowIterator.next();

        while (rowIterator.hasNext()) {

            final XSSFRow row = (XSSFRow) rowIterator.next();

            final Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {

                cell1 = (XSSFCell) cellIterator.next();

                final String key = cell1.getRichStringCellValue().toString();

                if (key == "")
                    break;

                cell2 = (XSSFCell) cellIterator.next();

                final String value = cell2.getRichStringCellValue().toString();

                map.put(key, value);

            }
        }
    }

    catch (final Exception e) {

    } finally {

        if (workbook != null)

            workbook.close();
    }
}