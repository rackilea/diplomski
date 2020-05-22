private static boolean checkCredentials(String user, String pass) throws IOException {

    Scanner sc = new Scanner(new File("Details.txt"));

    boolean userFound = false;
    String correctPassword = null;

    String line;
    while(sc.hasNextLine()) {
        line = sc.nextLine();
        // find the user
        if(!userFound) {
            userFound = line.contains("UserName = "+user);
        } else {
            // find the password
            if(line.contains("Password = ")) {
                correctPassword = line.substring(line.indexOf("=") + 2);
                break;
            }
        }
    }

    return correctPassword!=null && correctPassword.equals(pass);
}


public static void main(String[] args) throws IOException {
    System.out.println(checkCredentials("Bob", "dagg"));
    System.out.println(checkCredentials("ahmegg", "daggy"));
    System.out.println(checkCredentials("ahmegg", "dagg"));
}