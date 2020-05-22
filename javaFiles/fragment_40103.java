public void loginFromLibrary(Patron[] patrons){
    Scanner scan = new Scanner(System.in);
    while (true){
        // get usernmae
        System.out.println("Username > ");
        String username = scan.nextLine();
        Patron user = null;
        // check array to see if username exists
        for (Patron p : patrons){
            if (p.getUsername().equals(username)){
                user = p;
                break;
            }
        }
        if (user == null){
            // username not found
            System.out.println("Username not found");
            continue;
        }
        // get password
        System.out.println("Password > ");
        String pass = scan.nextLine();
        // check password
        if (pass.equals(user.getPassword())){
            // logged in
            break;
        } else {
            // wrong password
        }
    }
    scan.close();
}