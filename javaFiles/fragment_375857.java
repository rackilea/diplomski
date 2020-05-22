System.out.println("Please enter the first integer: ");

number = scan.nextInt();

// keep them in a loop until they enter a valid number
while (number < 0 || number > 100) {
    System.out.println("Please enter a valid number: ");
    number = scan.nextInt();
}

// after they entered a valid number, add it to the series
minimum = number;
total += number;

for(int i = 2; i < 11; i++) {

    System.out.println("Please enter integer " + i + ":");
    number = scan.nextInt();

    // keep them in a loop until they enter a valid number
    while (number < 0 || number > 100) {
        System.out.println("Please enter a valid number: ");
        number = scan.nextInt();
    }

    // after they entered a valid number, add it to the series

    total += number;

    if(number<minimum)
        minimum = number;
    if(number>maximum)
        maximum = number;
}