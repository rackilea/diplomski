public static void main(String[] args) throws Exception {
    // A Map for testing purpose representing the login and hash of your existing users
    Map<String, String> credentials = new HashMap<>();
    credentials.put("griffin.keyes", "108de81c31bf9c622f76876b74e9285f");
    credentials.put("rosario.dawson", "3e34baa4ee2ff767af8c120a496742b5");
    credentials.put("bernie.gorilla", "a584efafa8f9ea7fe5cf18442f32b07b");
    // Variable used to know if it was successful or not
    boolean success = false;
    BufferedReader scnr = new BufferedReader(new InputStreamReader(System.in));
    String username = null;
    // Iterate up to 3 times
    for (int i = 0; i < 3; ++i){
        System.out.println("Enter username:");
        username = scnr.readLine();
        System.out.println("Enter password:");
        String password1 = scnr.readLine();

        // Get the hash for the given username
        String hash = credentials.get(username);
        // Check if the username exists and if so check if the hash of his 
        // password matches with the hash of the provided password
        if (hash == null || !hash.equals(CredAndPass.CredAndPass(password1))) {
            // We don't have a match so we keep going
            System.err.println("User or password invalid");
            continue;
        }
        success = true;
        // Exit from the loop as we have a success
        break;
    }
    if (success) {
        System.out.printf("Welcome %s!%n", username);
    } else {
        System.out.println("Could not connect");
    }
}