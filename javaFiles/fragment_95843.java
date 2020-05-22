public enum UserProfileType {

USER("USER"),
DBA("DBA"),
ADMIN("ADMIN");

String type;

private UserProfileType(String userProfileType) {
    this.type = userProfileType;
}

public String getUserProfileType() {
    return type;
}

public UserProfileType getByName(String name) {
    return UserProfileType.valueOf(name);
}