public void run() {

    int intValue = 5;
    double doubleValue = 2.5;

    int product1 = product(intValue, intValue);
    System.out.println(product1);

    // Use method overloading to define methods
    // for each of the following method calls
    double product2 = product(doubleValue, doubleValue);
    System.out.println(product1);

    int product3 = product(intValue * intValue, intValue);
    System.out.println(product1);

    double product4 = product(intValue, doubleValue);
    System.out.println(product1);

    double product5 = product(doubleValue, intValue);
    System.out.println(product1);

    double product6 = product(doubleValue * doubleValue, doubleValue);
    System.out.println(product1);
}

public int product(int one, int two) {
    return one * two;
}

public double product(double one, double two) {
    return one * two;
}