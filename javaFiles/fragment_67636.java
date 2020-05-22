public class Element {

    private double coefficient;
    private int exponent;
    private String variable;

    public Element(double coefficient, String variable, int exponent ) {
        this.coefficient = coefficient;
        this.variable = variable;
        this.exponent = exponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

}