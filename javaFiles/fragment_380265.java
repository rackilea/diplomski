public class Table {

    public static DefaultTableModel buildDataTable(final ResultSet rs) {

        final List<Object[]> data = new ArrayList<>();
        String[] columnNames = null;
        int columnCount = 0;

        try {
            final ResultSetMetaData metaData = rs.getMetaData();
            columnCount = metaData.getColumnCount();
            columnNames = new String[columnCount];
            for (int column = 0; column < columnCount; column++) {
                columnNames[column] = metaData.getColumnName(column + 1).toUpperCase();
            }

            while (rs.next()) {
                final Object[] row = new Object[columnCount];
                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                    row[columnIndex] = rs.getObject(columnIndex + 1);
                }
                data.add(row);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new DefaultTableModel(data.toArray(new Object[data.size()][columnCount]), columnNames);
    }
}