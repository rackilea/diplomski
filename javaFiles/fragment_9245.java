public class UserConverter extends StdConverter<User, String> {
    @Override
    public String convert(User user) {
        return user.getTitle();
    }
}