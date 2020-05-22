public class CustomAggregationOperation implements AggregationOperation {
    private DBObject operation;

    public CustomAggregattionOperation (DBObject operation) {
        this.operation = operation;
    }

    @Override
    public DBObject toDBObject(AggregationOperationContext context) {
        return context.getMappedObject(operation);
    }
}