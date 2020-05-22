public class UserProfileTypeFormatter implements Formatter<UserProfileType> {

public UserProfileTypeFormatter() {
    super();
}

@Override
public String print(UserProfileType object, Locale locale) {
    return object.getType();
}

@Override
public UserProfileType parse(String text, Locale locale) throws ParseException {
    return UserProfileType.getByName(text);
}

}