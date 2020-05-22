public static double factorial(double x) throws NotAWholeNumber {

        if (x == 1 || x == 0) {
            return 1;
        }
        System.out.println(x % 2);
        if (x % 2 != 1.0 && x % 2 != 0.0) {
            throw new NotAWholeNumber("not a whole number");
        } else {
            double y = factorial(x - 1) * x;
            return y;
        }
    }