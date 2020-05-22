Scanner scanner = new Scanner(System.in);
int month, year;
for (; ; scanner.nextLine()) {
    System.out.println("What is your month and year of birth as [1-12] [1900-2012]");
    if (!scanner.hasNextInt()) {
        System.out.println("Your month is not a number");
        continue;
    }
    month = scanner.nextInt();
    if (month < 1 || month > 12) {
        System.out.println("Your month is out of range");
        continue;
    }
    if (!scanner.hasNextInt()) {
        System.out.println("Your year is not a number");
        continue;
    }
    year = scanner.nextInt();
    if (year < 1900 || year > 2012) {
        System.out.println("Your year is out of range");
        continue;
    }
    break;
}