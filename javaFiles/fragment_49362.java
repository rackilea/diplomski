public static void main(String[] args) {

    double bmi = 0.0;

    setInput(showInputDialog("Your weight in kg: "));
    double weight = Double.parseDouble(input);

    setInput(showInputDialog("Your length in m (with a comma): "));
    double length = Double.parseDouble(input);

    bmi = (weight / (length * length));