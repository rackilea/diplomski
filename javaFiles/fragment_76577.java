int n = num;
int result = num;
while (--num != 1) {
    result *= num;
    System.out.println(result);
}
System.out.printf("The factorial of %d is %d%n", n, result);