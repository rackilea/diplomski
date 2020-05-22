public class Calculation {
    private double leftOperand;
    private String operator;
    private double rightOperand;

    public double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
    }
}

public class Calculator {
    public double calculate(Calculation calculation) {
        switch (calculation.getOperator()) {
            case "+":
                return calculation.getLeftOperand() + calculation.getRightOperand();
            case "-":
                return calculation.getLeftOperand() - calculation.getRightOperand();
            case "/":
                if (calculation.getRightOperand() == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero!");
                }
                return calculation.getLeftOperand() / calculation.getRightOperand();
            case "*":
                return calculation.getLeftOperand() * calculation.getRightOperand();
            default:
                throw new IllegalArgumentException(String.format("%s is not valid function", calculation.getOperator()));
        }
    }
}

public class SimpleFrontEnd {
    public static void main(String[] args) {
        try {
            //1. input, could be later replaced with a front end
            Scanner typ = new Scanner(System.in);
            System.out.println("Enter the first number: ");
            double x = typ.nextDouble();
            System.out.println("Enter the function: ");
            String func = typ.next();
            System.out.println("Enter the second number: ");
            double y = typ.nextDouble();

            //2. store input in an data object that will be sent to the back end (later on, a web interface could send this as a JSON)
            Calculation calculation = new Calculation();
            calculation.setLeftOperand(x);
            calculation.setOperator(func);
            calculation.setRightOperand(y);

            //3. retrieve the result from the back end
            Calculator calculator = new Calculator();
            try {
                double result = calculator.calculate(calculation);
                System.out.println(String.format("The result is: %f", result));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } catch (InputMismatchException e) {
            System.out.println("Please use only numbers!");
        }
    }
}