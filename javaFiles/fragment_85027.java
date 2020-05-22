public class User implements Serializable {

    private static User instance;

    private String studyProgram;
    private String name;
    private String facebookId;
    private String vuId;

    private User() {}

    public static User getInstance(){
        if (instance == null){
            instance = new User();
        }
        return instance;
    }
    ...
}