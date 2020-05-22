final class OperatorDefinition {

    @SerializedName("operators")
    @Expose
    private final Operator operators = null;

    @SerializedName("first")
    @Expose
    private final String first = null;

    @SerializedName("second")
    @Expose
    private final String second = null;

    @SerializedName("result")
    @Expose
    private final String result = null;

    private OperatorDefinition() {
    }

    @Override
    public String toString() {
        return new StringBuilder("OperatorDefinition{")
                .append("operators=").append(operators)
                .append(", first='").append(first)
                .append("', second='").append(second)
                .append("', result='").append(result)
                .append("'}")
                .toString();
    }

}