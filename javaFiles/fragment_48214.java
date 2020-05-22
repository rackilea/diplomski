public static void main(String[] args) {
    Scanner username = new Scanner(System.in);
    String uname;
    System.out.println("Please enter your username: ");

    boolean tooShort = true;
    do {
        uname = username.next();

        if (uname.length() <= 3)
            System.out.println("Sorry username is too short try again");
        else {
            System.out.println("Welcome Mr/Mrs: " + uname);
            tooShort = false;
        }

    } while (tooShort);

    username.close();
}