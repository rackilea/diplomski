public class ComplexNumber {
    private int a;
    private int b;

public ComplexNumber(int x, int y) {
    a = x;
    b = y;
}

public ComplexNumber add(ComplexNumber other) {
    int tempA = a + other.a;
    int tempB = b + other.b;

    return new ComplexNumber(tempA, tempB);
}