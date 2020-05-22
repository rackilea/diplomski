class ValidateDouble {

        public static void main(String[] args) {

        // Your initial value
        double value = 0;
        System.out.println("Your initial value is: " + value);

        // Not valid argument, should print 0 as returned from method
        value = inputDouble(-1);
        System.out.println("After entering -1, your value is: " + value);

        // Not valid argument, should print 0 as returned from method
        value = inputDouble(-1.5);
        System.out.println("After entering -1.5, your value is: " + value);

        // Not valid argument, should print 0 as returned from method
        value = inputDouble(25);
        System.out.println("After entering 25, your value is: " + value);

        // Valid argument, should print the returned argument value
        value = inputDouble(2);
        System.out.println("\nAfter entering 2, your value is: " + value);

        // Valid argument, should print the returned argument value 
        value = inputDouble(2.54);
        System.out.println("\nAfter entering 2.54, your value is: " + value);

    }

    private static double inputDouble (double number) {

        // Program will try to execute this
        try {

            // If number is out of range, throw exception if not, return the argument.
            if (number < 0 || number > 24) {
                throw new IllegalArgumentException("\nNot a valid argument...");
            } else {
                return number;
            }

        } catch (IllegalArgumentException exception) {

            // Print message thrown in the exception and return 0.
            System.out.println(exception.getMessage());
            return 0;
        }

    }

}