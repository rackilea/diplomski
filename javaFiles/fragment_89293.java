public class Calculator {

    private static final int BASE = 10;
    private int _value;
    private int _va;
    private CalculatorUI _ui;
    private Operator op;

    private enum Operator {
        ADD, SUB, MUL, DIV, NO_OPERATION
    };

    public Calculator(CalculatorUI calculatorUI) {
        op = Operator.NO_OPERATION;
        _ui = calculatorUI;
        _value = 0;
    }

    public void digit_0_keyPressed() {
        _value = _value * BASE + 0;
        _ui.updateDisplay();
    }

    public void digit_1_keyPressed() {
        _value = _value * BASE + 1;
        _ui.updateDisplay();
    }

    public void digit_2_keyPressed() {
        _value = _value * BASE + 2;
        _ui.updateDisplay();
    }

    public void digit_3_keyPressed() {
        _value = _value * BASE + 3;
        _ui.updateDisplay();
    }

    public void digit_4_keyPressed() {
        _value = _value * BASE + 4;
        _ui.updateDisplay();
    }

    public void digit_5_keyPressed() {
        _value = _value * BASE + 5;
        _ui.updateDisplay();
    }

    public void digit_6_keyPressed() {
        _value = _value * BASE + 6;
        _ui.updateDisplay();
    }

    public void digit_7_keyPressed() {
        _value = _value * BASE + 7;
        _ui.updateDisplay();
    }

    public void digit_8_keyPressed() {
        _value = _value * BASE + 8;
        _ui.updateDisplay();
    }

    public void digit_9_keyPressed() {
        _value = _value * BASE + 9;
        _ui.updateDisplay();
    }

    public void clear_keyPressed() {
        _value = 0;
        _ui.updateDisplay();
    }

    public int getValue() {
        return _value;
    }

    public void equal_keyPressed(String uimessage) {
        if (Operator.ADD.equals(op)) {
            _value += _va;
        } else if (Operator.MUL.equals(op)) {
            _value *= _va;
        } else if (Operator.DIV.equals(op)) {
            _value = _va / _value;
        } else if (Operator.SUB.equals(op)) {
            _value = _va - _value;
        }
        _va = 0;
        op = Operator.NO_OPERATION;
        _ui.updateDisplay();
    }

    public void add_keyPressed() {
        if (!Operator.NO_OPERATION.equals(op)) {
            equal_keyPressed();
        } else {
        _ui.updateDisplay();
        }

        _va = _value;
        _value = 0;
        op = Operator.ADD;
    }

    public void mul_keyPressed() {
        if (!Operator.NO_OPERATION.equals(op)) {
            equal_keyPressed();
        } else {
            _ui.updateDisplay();
        }

        _va = _value;
        _value = 0;
        op = Operator.MUL;
    }
}