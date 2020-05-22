public class Calculator {

    private final ObservableList<String> formulaParts = FXCollections.observableArrayList();
    private final ObservableList<String> formulaPartsUnmodifiable = FXCollections.unmodifiableObservableList(formulaParts);
    private final ReadOnlyStringWrapper operandString = new ReadOnlyStringWrapper();
    private Integer operand;
    private Integer previousOperand;
    private IntBinaryOperator operator;
    private boolean operandModifiable = true;

    /** previous input elements as Strings */
    public ObservableList<String> getFormulaParts() {
        return formulaPartsUnmodifiable;
    }

    public final String getOperand() {
        return this.operandString.get();
    }

    /** property contains current input as String */
    public final ReadOnlyStringProperty operandProperty() {
        return this.operandString.getReadOnlyProperty();
    }

    public void addDigit(byte digit) {
        if (operandModifiable) {
            operand = operand == null ? digit : operand * 10 + digit;
            operandString.set(Integer.toString(operand));
        }
    }

    public void addBinaryOperator(IntBinaryOperator operator) {
        if (operand != null) {
            if (previousOperand != null) {
                evaluate();
            }

            previousOperand = operand;
            operand = null;
            operandString.set("");
            formulaParts.setAll(Integer.toString(previousOperand), operator.toString());
            this.operator = operator;
            operandModifiable = true;
        }
    }

    public void evaluate() {
        if (operand != null && operator != null) {
            int result = operator.applyAsInt(previousOperand, operand);
            formulaParts.clear();
            operandString.set(Integer.toString(result));
            operandModifiable = false;
            previousOperand = null;

            operand = result;
        }
    }

}