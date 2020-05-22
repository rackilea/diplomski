private static List<Employee> parseCSVFileAsList() throws IOException {
            CSVReader reader = new CSVReader(new FileReader("employees.csv"), ',');

        List<CSVTable> csvObjects = new ArrayList<CSVTable>();
        //read all lines at once
        List<String[]> records = reader.readAll();
        String[] columns = null;
        String[] record = null;
        int length = 0;
        Iterator<String[]> iterator = records.iterator();
        //skip header row

        record = iterator.next();
        length = record.length;
        columns = new String[length];
        for(int i = 0; i < length; i++)
        {
            columns[i] = record[i];
        }


        while(iterator.hasNext()){
            record = iterator.next();
            CSVTable csvTable = new CSVTable(record.length);
            String[][] insertRecord = csvTable.getCSVTable();
            for(int i = 0; i < length; i++)
            {
                insertRecord[i][0] = columns[i];
                insertRecord[i][1] = record[i];
            }
            csvTable.setCSVTable(insertRecord);
            csvObjects.add(csvTable);
        }

        reader.close();

        System.out.println(csvObjects);
        return csvObjects;
    }