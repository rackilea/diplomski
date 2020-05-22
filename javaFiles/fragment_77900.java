@Access(AccessType.PROPERTY)
@Column(length = 10, name = "user_type")
public String getUserType() {
    return this.userType.getType();
}

public void setUserType(UserType userType) {
    this.userType = userType;
}

protected void setUserType(String userType) {
    userType = UserType.toUserType(userTypeS);
}