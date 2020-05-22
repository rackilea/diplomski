Optional<User> user = ...
user.ifPresent(new Consumer<User>() {
    @Override
    public void accept(User theUser) {
        doSomethingWithUser(theUser);
    }
});