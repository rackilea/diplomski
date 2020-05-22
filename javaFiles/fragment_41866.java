public class MyTableType {

    private String value;

    public MyTableType(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

CellTable<MyTableType> table = new CellTable<MyTableType>();

MyEditTextCell cell = new MyEditTextCell();

Column<MyTableType, String> column = new Column<MyTableType, String>(cell) {
    @Override
    public String getValue(MyTableType object) {
        if(object.getValue() == null)
            return "";
        else
            return object.getValue();
    }
};
column.setFieldUpdater(new FieldUpdater<MyTableType, String>() {
    @Override
    public void update(int index, MyTableType object, String value) {
        object.setValue(value);
    }
});

table.addColumn(column, "Value");

ArrayList<MyTableType> values = new ArrayList<MyTableType>();
values.add(new MyTableType("one"));
values.add(new MyTableType("two"));
values.add(new MyTableType("three"));
values.add(new MyTableType(null));
values.add(new MyTableType(""));
table.setRowData(values);