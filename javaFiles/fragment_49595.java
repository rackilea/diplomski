public static void enterPassword() throws Exception {
    Scanner sc = new Scanner(System.in);
    String password;
    System.out.print("Enter your password : ");
    password = sc.next();
    if (!password.equals("password")) {
        throw new Exception();
    }
}

public static void printPassword() {
    try {
        enterPassword();
    } catch (Exception e) {
        System.out.println("Your password is incorrect. Try again!");
        printPassword();
    }
}

public static void main(String[] args) {


    System.out.println("Welcome to Facebook!");

    printPassword();

    System.out.println("Congratulations, you have logged in to Facebook!");


}