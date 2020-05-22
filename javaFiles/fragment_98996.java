public class ExampleStrategy extends DelegatingReverseEngineeringStrategy {
    public ExampleStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }
    public String columnToPropertyName(TableIdentifier table, String column) {
        if(column.endsWith("PK")) {
            return "id";
        } else {
            return super.columnToPropertyName(table, column);
        }
    }
}