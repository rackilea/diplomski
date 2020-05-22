final JTable table = new JTable();

SwingWorker<Void, TableModel> worker = new SwingWorker<Void, TableModel> () {

    @Override
    protected Void doInBackground() throws Exception {

        ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount(); // columns number
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i] = metaData.getColumnName(i); // fill columns names
        }

        resultSet.last();
        int rowCount = resultSet.getRow(); // get rows number
        resultSet.beforeFirst();

        Object[][] data = new Object[rowCount][columnCount];
        int currentRow = 0;
        while (resultSet.next()) {
            for (int currentColumn = 1; currentColumn <= columnCount; currentColumn++) {
                data[currentRow][currentColumn - 1] = resultSet.getObject(currentColumn); // fill data set
             }
             currentRow++;
        }

        TableModel model = new DefaultTableModel(data, columnNames);
        publish(model);

        return null;
    }

    @Override
    protected void process(List<TableModel> chunks) {
        TableModel model = chunks.get(0);
        table.setModel(model);
    }
}

worker.execute();