// for load and create reference
public User loadUser() {
    return user.get();
}
public void referenceUser(User user) {
    this.user = Ref.create(user);
}