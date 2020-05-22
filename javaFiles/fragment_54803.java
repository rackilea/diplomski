public class CSVDataReader {
    private static final char DELIMITER = ',';
    private static final char QUOTE_CHAR = '\"';
    private static final char ESCAPE_CHAR = '\\';

    private static List<String[]> read(String filePath, boolean hasHeader) throws IOException {
        CSVReader reader;

        if (hasHeader) {
            // If file has a header, skip the header (line 1)
            reader = new CSVReader(new FileReader(filePath), DELIMITER, QUOTE_CHAR, ESCAPE_CHAR, 1);
        } else {
            reader = new CSVReader(new FileReader(filePath), DELIMITER, QUOTE_CHAR, ESCAPE_CHAR);
        }

        List<String[]> rows = reader.readAll();
        reader.close();

        return rows;
    }

    public static String [][] readCSVFileToString2DArray(String filePath, boolean hasHeader) throws IOException {
        List<String[]> rows = read(filePath, hasHeader);

        // Store all rows/columns in a two-dimensional String array, then return it
        String [][] csvData = new String[rows.size()][];

        int r = 0;
        for (String[] row : rows) {
            csvData[r++] = row;
        }

        return csvData;
    }
}