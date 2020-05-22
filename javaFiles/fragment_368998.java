System.out.println("Please enter a number: ");
Scanner input = new Scanner(System.in);
int number = input.nextInt();
BigInteger fact = BigInteger.ONE;
for (int i = 2; i <= number; i++) { // <-- x * 1 = x
    fact = fact.multiply(BigInteger.valueOf(i));
}
System.out.println("Factorial of " + number + " is: " + fact);