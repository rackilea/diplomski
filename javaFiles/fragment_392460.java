public class DataType {
    public static String DATA_TYPE_1 = "dataType1";
    public static String DATA_TYPE_2 = "dataType2";
    public static String DATA_TYPE_3 = "dataType3";
}

public class Column() {
    private String name;
    private DataType dataType;
    private boolean PK;
    private boolean NN;

    // getters and setters
}

public class Table {
    private ArrayList<Column> columns;

    public Table() {
        columns = new ArrayList<Column>();
    }

    public boolean AddColumn(Column column) {
        columns.add(column);
    }

    public boolean DeleteColumn(String name) {
        for (Column c : columns) {
            if (c.getName().equals(name)) {
                return columns.remove(column);
            }
        }
        return false;
    }
}