public double[][] getParsedTable() throws IOException {
    double[][] table = new double[4][10];
    int indexRow = 0;
    int indexColumn = 0;
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    br.readLine(); // ignore first line
    br.readLine(); // ignore second line
    br.readLine(); // ignore third line (contains title)
    String line;
    while (true) {
        line = br.readLine();
        if (line == null) break; // end of file reading

        int index = 0;
        while (true) {
            index = line.indexOf(",", index) + 1;
            if (Character.isDigit(line.charAt(index))) {
                break;
            }
        }

        // from index, line is expected to contain comma separated numbers
        String[] array = line.substring(index).split(",");
        for (int i = 0; i < array.length; i++) {
            table[indexRow][indexColumn] = Double.parseDouble(array[i]);
            indexColumn++;
        }
        indexColumn = 0;
        indexRow++;
    }
    System.out.print(Arrays.deepToString(table));
    return table;
}