public static void main(String[] args) {

    Console console = System.console();
    if(console == null){
        System.out.println("ERROR: Couldn't get Console");
        return;
    }
    boolean passwordUpdated = false;
    while (!passwordUpdated) {

        System.out.print("Enter password :");
        String password = console.readLine();
        // char[] password = console.readPassword() // can be used

        if (password != null && password.length() > 0) {
            System.out.println("Password Updated");
            passwordUpdated = true;
        } else {
            System.out.println("WARN: Invalid password, please try again");
        }
    }
}