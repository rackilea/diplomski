int userInput = num.nextInt();

for (int number = 1; number < userInput; number++) {
    if (userInput % number == 0) {
        System.out.println(number + " is a factor of " + userInput);
    }
}