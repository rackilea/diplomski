int attempts = 0;
Scanner keyboard = new Scanner(System.in);
String password = null;
String CORRECT_PWORD = "1234";
String Options = null;
do {
    System.out.print("Enter Pin Code: ");
    password = keyboard.next();
    if (!password.equals(CORRECT_PWORD)) {
        System.out.println("Password is incorrect!");
        attempts++;
    }
} while (!password.equals(CORRECT_PWORD) && attempts < 3);