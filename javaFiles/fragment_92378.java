public class UserFactory {

    public static User newUser(UserEnum type){
        switch (type){
            case ADMIN: return new Admin();
            case STAFF: return new StaffMember();
            case CLIENT: return new Client();
            default:
                throw new IllegalArgumentException("Unsupported user. You input: " + type);
        } 
    }
}