Scanner scanner = new Scanner(System.in);
int num;

while (true) {
    try {
        System.out.println("Enter a number: ");
        num = scanner.nextInt();
        if (num >= 1 && num <= 5) {
            break;
        }
    } catch (InputMistmatchException ex){
        System.err.println("Input needs to be a number between 1 and 5, dummy.");
    }
}