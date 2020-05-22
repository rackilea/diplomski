public class FilterExpression<T extends Comparable<T>> {

    public static final Integer BEGINS_WITH = 0;
    public static final Integer ENDS_WITH = 1;
    public static final Integer CONTAINS = 2;
    public static final Integer EQUAL = 3;
    public static final Integer NOT_EQUAL = 4;
    public static final Integer GREATER_THAN = 5;
    public static final Integer GREATER_EQUAL_THAN = 6;
    public static final Integer LESS_THAN = 7;
    public static final Integer LESS_EQUAL_THAN = 8;
    private static final Map<String, Integer> OPERATOR_MAPPING;

    static {
        Map<String, Integer> temp = new HashMap<>();
        temp.put("bw", BEGINS_WITH);
        temp.put("ew", ENDS_WITH);
        temp.put("ct", CONTAINS);
        temp.put("eq", EQUAL);
        temp.put("nq", NOT_EQUAL);
        temp.put("gt", GREATER_THAN);
        temp.put("gq", GREATER_EQUAL_THAN);
        temp.put("lt", LESS_THAN);
        temp.put("lq", LESS_EQUAL_THAN);
        OPERATOR_MAPPING = Collections.unmodifiableMap(temp);
    }

    private String field;
    private Integer operator;
    private T value;

    public FilterExpression(String field, String operator, T value) {
        this.field = field;
        setOperator(operator);
        this.value = value;
    }

    public Boolean validate() {
        if (StringUtils.isEmpty(field) || operator == null || value == null) {
            return false;
        }
        Class c = value.getClass();

        if (c == String.class) {
            return operator >= BEGINS_WITH && operator <= NOT_EQUAL;
        } else if (c == Integer.class || c == Float.class || c == Double.class || c == Date.class) {
            return (EQUAL >= EQUAL && operator <= LESS_EQUAL_THAN);
        } else if (c == Boolean.class) {
            return operator == EQUAL || operator == NOT_EQUAL;
        } else if (c == Identification.Type.class) {
            return operator == EQUAL || operator == NOT_EQUAL;
        }
        return false;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = OPERATOR_MAPPING.get(operator.toLowerCase());
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public <R> Predicate toPredicate(CriteriaBuilder cb, Root<R> root) {
        if (Objects.equals(operator, FilterExpression.EQUAL)) {
            return cb.equal(root.<T>get(field), value);
        } else if (Objects.equals(operator, FilterExpression.NOT_EQUAL)) {
            return cb.notEqual(root.<T>get(field), value);
        } else if (Objects.equals(operator, FilterExpression.CONTAINS)) {
            return cb.like(root.<String>get(field), "%" + value + "%");
        } else if (Objects.equals(operator, FilterExpression.ENDS_WITH)) {
            return cb.like(root.<String>get(field), "%" + value);
        } else if (Objects.equals(operator, FilterExpression.BEGINS_WITH)) {
            return cb.like(root.<String>get(field), value + "%");
        } else if (Objects.equals(operator, FilterExpression.GREATER_THAN)) {
            return cb.greaterThan(root.<T>get(field), (T) value);
        } else if (Objects.equals(operator, FilterExpression.GREATER_EQUAL_THAN)) {
            return cb.greaterThanOrEqualTo(root.<T>get(field), (T) value);
        } else if (Objects.equals(operator, FilterExpression.LESS_THAN)) {
            return cb.lessThan(root.<T>get(field), (T) value);
        } else if (Objects.equals(operator, FilterExpression.LESS_EQUAL_THAN)) {
            return cb.lessThanOrEqualTo(root.<T>get(field), (T) value);
        } 
        return null;
    }

}