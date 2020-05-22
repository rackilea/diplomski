String[] headerColumns = (String[]) myEntries.get(0);
    // First column is TimeStamp, skip it
    for (int i = 1; i < headerColumns.length; i++) {

        List<String[]> list = new ArrayList<String[]>();
        for (int rowIndex = 1; rowIndex < myEntries.size(); rowIndex++) {
            String[] row = (String[]) myEntries.get(rowIndex);
            list.add(new String[] { row[0], row[i] });
        }

        Results.put(headerColumns[i], list);
    }