int i = 0;
while(i < number) {
    try {
        System.out.println("Enter the value " + (i+1) + "/" + number + ":");
        value[i] = input.nextInt();
        i++;
    } catch(InputMismatchException e) {
        System.out.println("This is not a valid input! Please enter it again!");
        input.next();   // This consume the invalid token
    }
}