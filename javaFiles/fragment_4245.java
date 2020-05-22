@Index private Ref<User> user;

// for serialization
public String getUser() {
    return user.getKey().getString(); // .toWebSafeString() will be added in future version of objectify and .toWebSafeString() will do the same as .getString()
}
public void setUser(String webSafeString) {
    Key<User> key = Key.create(webSafeString);
    this.user = Ref.create(key);
}