public class QueryBuilder {
    final String[] token;
    int i = 0;

    public static Expression parse(String query) {
        return new QueryBuilder(query).expression();
    }

    private QueryBuilder(String query) {
        token = query.split("\\s+");
    }

    private Expression expression() {
        Expression expr = binaryExpression();
        while (i < token.length) {
            String operator = token[i++];
            Expression right = binaryExpression();
            switch (operator) {
                case "AND":
                    expr = new BooleanExpression(expr, Operator.AND, right);
                    break;
                default:
                    expr = new BooleanExpression(expr, Operator.OR, right);
                    break;
            }
        }
        return expr;
    }

    private Expression binaryExpression() {
        String field = token[i++];
        String operator = token[i++];
        String value = token[i++];

        switch (operator) {
            case "EQ":
                return new BinaryExpression(field, Operator.EQ, value);
            case "LT":
                return new BinaryExpression(field, Operator.LT, value);
            case "GT":
                return new BinaryExpression(field, Operator.GT, value);
            default:
                return new BinaryExpression(field, Operator.IN, value);
        }
    }
}