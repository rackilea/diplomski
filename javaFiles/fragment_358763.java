interface Calculation {
  double calculate(double op1, double op2);
}

class AddCalculation implements Calculation {
  double calculate(double op1, double op2) {
    return op1 + op2;
  }
}

//others as well

Map<String, Calculation> m = ...;

m.put("+", new AddCalculation());