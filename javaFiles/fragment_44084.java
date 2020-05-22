public void setUser(User user) {
    synchronized (this) {
        this.user = user;
        userId = user == null ? null : user.getId();
        user__resolvedKey = userId;
    }
}