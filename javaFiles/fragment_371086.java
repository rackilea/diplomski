try (BufferedWriter writer = Files.newBufferedWriter(
     Paths.get(OUTPUT + "/" + project + "/" + project + ".csv"));)
{
    CSVPrinter csvPrinter = new CSVPrinter(writer,
        CSVFormat.RFC4180.withFirstRecordAsHeader());

    // This assumes that the rowCollection will never be empty.
    // An anonymous scope block just to limit the scope of the variable names.
    {
        HashMap<String, String> firstRow = rowCollection.get(0);
        int valueIndex = 0;
        String[] valueArray = new String[firstRow.size()];

        for (String currentValue : firstRow.values())
        {
            valueArray[valueIndex++] = currentValue;
        }

        csvPrinter.printrecord(valueArray);
    }

    for (HashMap<String, String> row : rowCollection)
    {
        int valueIndex = 0;
        String[] valueArray = new String[row.size()];

        for (String currentValue : row.values())
        {
            valueArray[valueIndex++] = currentValue;
        }

        csvPrinter.printrecord(valueArray);
    }

    csvPrinter.flush();
}