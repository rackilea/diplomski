class AddANewUser implements Performable {

    public static Performable called(String userName) {
        return instrumented(AddANewUser.class, userName);
    }

    private final String userName;

    AddANewUser(String userName) {
        this.userName = userName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Add a new user called userName via the UI
    }
}