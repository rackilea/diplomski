String file = "C:\\logins.txt";
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String username;
    String pw;

    System.out.println("Please enter a username");

    BufferedReader bru = new BufferedReader(new FileReader(file));
    // we will keep the users here instead of reading the file everytime a username is entered
    List<String> users = new ArrayList<>();

    Boolean exists = null;
    String line;

    // populate the existing users list by reading all the lines in the file
    while ((line = bru.readLine()) != null) {
        users.add(line.split(":")[0]);
    }

    bru.close();

    // we can enter the while loop if we are asking for the username for the first time
    // or if the username entered already exists
    while (exists == null || exists == true) {
        // we read the username from the input
        username = in.readLine();
        // we suppose it doesn't already exist
        exists = false;
        // we look at every existing user
        for (String user : users) {
            /*
             * if the names are the same, we don't need to look further, we know the username
             * exists and so we will break from the "for" loop and ask for a username once again
             * (side note: I used replaceAll in order to remove all invisible unicode characters
             * that might make two strings unequal that would otherwise be identical)
             */
            if (user.replaceAll("\\P{Print}", "").equals(username.replaceAll("\\P{Print}", ""))) {
                System.out.println("There is already a User with that username, please try a other username");
                exists = true;
                break;
            }
        }

    }

    System.out.println("Please enter a password");
    pw = in.readLine();