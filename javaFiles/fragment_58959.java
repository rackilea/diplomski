public class SalesTable extends AbstractTable {

    private static final String TABLE_NAME = "Sales";

    public String getTag() {
        return TABLE_NAME;
    }

    public void init() {
        ...
        String tableName = getTag();
        ...
    }

}