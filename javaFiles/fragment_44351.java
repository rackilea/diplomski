System.out.println("Type a number");
Scanner num = new Scanner(System.in);
double userInput = num.nextDouble();
for (double number = 1; userInput % number == 0; number++) {
    if (userInput % number != 0) {
        continue;
    }

    if (number > userInput) {
        break;
    }

    System.out.println(number + "is a factor of " + userInput);
}