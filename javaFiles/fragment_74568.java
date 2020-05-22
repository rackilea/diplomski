public class FilterExpression {

    private List<Filter> filters;

    private String filterExpression;

    private Map<String, AttributeValue> attributeValues;

    private Map<String, String> attributeNames;

    public FilterExpression(List<Filter> filters) {
        this.filters = filters;
        populateFilterExpression();
    }

    private void populateFilterExpression() {
        StringBuilder filterExpressionBuilder = new StringBuilder();
        attributeNames = new HashMap<>();
        attributeValues = new HashMap<>();

        for (Filter filter: filters) {
            if (filterExpressionBuilder.length() > 0) {
                filterExpressionBuilder.append(" AND ");
            }
            String attributeName = filter.getAttributeName();
            String[] attributes = attributeName.split("\\.");

            StringBuilder expNestedAttributes = new StringBuilder();
            for (String attributeInPath: attributes) {
                attributeNames.put("#"+attributeInPath, attributeInPath);
                if(expNestedAttributes.length() > 0) {
                    expNestedAttributes.append(".");
                }
                expNestedAttributes.append("#" + attributeInPath);
            }

            String attributeValueKey = ":" + String.join("", attributes);

            AttributeValue attributeValue;
            switch (filter.getAttributeType()) {
                case STRING:
                    attributeValue = new AttributeValue().withS(filter.getAttributeValue());
                    break;

                case NUMBER:
                    attributeValue = new AttributeValue().withN(filter.getAttributeValue());
                    break;

                default:
                    throw new UnsupportedOperationException("The attribute type is not supported");
            }
            attributeValues.put(attributeValueKey, attributeValue);

            switch (filter.getOperation()) {
                case EQ:
                    filterExpressionBuilder.append(expNestedAttributes);
                    filterExpressionBuilder.append(" = ");
                    filterExpressionBuilder.append(attributeValueKey);
                    break;

                case GE:
                    filterExpressionBuilder.append(expNestedAttributes);
                    filterExpressionBuilder.append(" >= ");
                    filterExpressionBuilder.append(attributeValueKey);
                    break;

                case LE:
                    filterExpressionBuilder.append(expNestedAttributes);
                    filterExpressionBuilder.append(" <= ");
                    filterExpressionBuilder.append(attributeValueKey);
                    break;

                case GT:
                    filterExpressionBuilder.append(expNestedAttributes);
                    filterExpressionBuilder.append(" > ");
                    filterExpressionBuilder.append(attributeValueKey);
                    break;

                case LT:
                    filterExpressionBuilder.append(expNestedAttributes);
                    filterExpressionBuilder.append(" < ");
                    filterExpressionBuilder.append(attributeValueKey);
                    break;

                case STARTS_WITH:
                    filterExpressionBuilder.append("begins_with (");
                    filterExpressionBuilder.append(expNestedAttributes);
                    filterExpressionBuilder.append(", ");
                    filterExpressionBuilder.append(attributeValueKey);
                    filterExpressionBuilder.append(")");
                    break;

                case CONTAINS:
                    filterExpressionBuilder.append("contains (");
                    filterExpressionBuilder.append(expNestedAttributes);
                    filterExpressionBuilder.append(", ");
                    filterExpressionBuilder.append(attributeValueKey);
                    filterExpressionBuilder.append(")");
                    break;

                default:
                    throw new UnsupportedOperationException("filter is not supported");
            }
        }

        filterExpression = filterExpressionBuilder.toString();
    }

    public String getFilterExpression() {
        return filterExpression;
    }

    public Map<String, AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public Map<String, String> getAttributeNames() {
        return attributeNames;
    }

    @Override
    public String toString() {
        return filterExpression;
    }
}