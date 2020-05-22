public class HandlingExceptions {

    private static final String INPUT = 
        "name\tage\nTom\t25\nAlice\nJim\t44\nMary\t33\tInvalid";

    public static void main(String[] args) throws IOException {

        // use CsvListReader (can't be sure there's the correct no. of columns)
        ICsvListReader listReader = new CsvListReader(new StringReader(INPUT), 
            new CsvPreference.Builder('"', '\t', "\r\n").build());

        final String[] headers = listReader.getHeader(true);

        List<String> row = null;
        while ((row = listReader.read()) != null) {

            if (listReader.length() != headers.length) {
                // skip row with invalid number of columns
                System.out.println("skipping invalid row: " + row);
                continue;
            }

            // safe to create map now
            Map<String, String> rowMap = new HashMap<String, String>();
            Util.filterListToMap(rowMap, headers, row);

            // do something with your map
            System.out.println(rowMap);
        }
        listReader.close();
    }
}