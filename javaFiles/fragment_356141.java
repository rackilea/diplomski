public void parseFields() {
    String delimiter = ",\n";

    // Create two-dimensional array to hold data (see Deitel, p 313-315)
    int rows = records.size(); // #rows for array = #lines in file
    data = new String[rows][]; // create the rows for the array
    int row = 0;

    for (String record : records) {
        StringTokenizer tokens = new StringTokenizer(record, delimiter);
        int cols = tokens.countTokens();
        data[row] = new String[cols]; // create columns for current row
        int col = 0;
        while (tokens.hasMoreTokens()) {
            data[row][col] = tokens.nextToken().trim();
            // System.out.print(data[row][col] + " ");
            col++;
        }

        row++;
    }
}