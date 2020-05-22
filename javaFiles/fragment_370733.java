public class ParseUserSingleton {

    private static ParseUserSingleton instance;

    public ParseUser user;
    public HashMap<String, String> userFields = new HashMap<>();

    public static void initInstance() {
        if (instance == null) {
            // Create the instance
            instance = new ParseUserSingleton();
        }
    }

    public static ParseUserSingleton getInstance() {
        // Return the instance
        return instance;
    }

    private ParseUserSingleton() {
        // Constructor hidden because this is a singleton
    }

    public void customSingletonMethod() {
        try {
            user = ParseUser.getCurrentUser().fetch();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        userFields.put("name", user.get("availability").toString());
        // repeat for other fields
    }
}