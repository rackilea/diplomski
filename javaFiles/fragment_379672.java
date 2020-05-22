while (scanner.hasNextLine()) {
    String fileline = scanner.nextLine();
    if (!(fileline.equals(hashedP))) {
        System.out.println("Login Failed!");
        LoginMenu();
    }
    else {
        System.out.println("Login Successful.\n");
        AdminMenu();
    }
}