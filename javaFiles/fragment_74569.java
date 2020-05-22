public class Filter {

    private String attributeName;

    private String attributeValue;

    private Operation operation;

    private AttributeType attributeType;

    public enum Operation {
        EQ, GE, LE, GT, LT, CONTAINS, STARTS_WITH
    }

    public enum AttributeType {
        STRING, NUMBER
    }
}