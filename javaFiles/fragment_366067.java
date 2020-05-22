Scanner scanner = new Scanner(System.in);
int biggest = 0;
int occurance = 0;
int num;

while (true) {
    System.out.print("Enter a number: ");
    // this may throw an Exception if the users input is not a number
    num = Integer.parseInt(scanner.nextLine());
    if(num == 0) {
        // user entered a 0, so we exit the loop
        break;
    }
    if(num > biggest) {
        biggest = num;
        occurance = 1;
    } else if(num == biggest) {
        biggest++;
    }
}
System.out.printf("Biggest number %s occured %s times.%n", biggest, occurance);