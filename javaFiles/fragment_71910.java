int x = 2_000_000_000;
int y = 1_000_000_000;
try {
    int result = Math.addExact(x, y);
    System.out.println("The proper result is " + result);
} catch(ArithmeticException e) {
    System.out.println("Sorry, " + e);
}