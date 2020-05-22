Scanner input = new Scanner(System.in);
String year;
boolean pass = false;
do {
    System.out.print("Enter a Year (2000-2016): ");
    year = input.next();
    try {
        if (Integer.parseInt(year) >= 2000 && Integer.parseInt(year) <= 2006) {
            System.out.println("true");
            pass = true;
        }
    } catch (NumberFormatException e) {
        System.out.println("Not correct try again");
    }
} while (!pass);