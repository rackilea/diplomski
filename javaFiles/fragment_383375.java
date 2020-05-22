public double calculate() {
    return _calculate();
}
private double _calculate() {
    return 1.0;
}
@Override
public String toString(){
    return String.format("Result = %s", _calculate());
}