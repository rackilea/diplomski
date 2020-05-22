int counter = 0;
int result = 1;

while (counter < 6) {
    System.out.println("Enter a number");
    int number = scanner.nextInt();
    result = result * number;
    counter++;
}

System.out.println("The product of your numbers entered are: " + result);