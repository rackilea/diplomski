public class AuthenticationState {

    private final BooleanProperty loggedIn = new SimpleBooleanProperty(false);

    public BooleanProperty loggedInProperty() {
        return loggedIn ;
    }

    public final boolean isLoggedIn() {
        return loggedInProperty().get();
    }

    public final void setLoggedIn(boolean loggedIn) {
        loggedInProperty().set(loggedIn);
    }

    private final StringProperty userName = new SimpleStringProperty();

    public StringProperty userNameProperty() {
        return userName ;
    }

    public final String getUserName() {
        return userNameProperty().get();
    }

    public final void setUserName(String userName) {
        userNameProperty().set(userName);
    }

    // other properties as needed, e.g. IntegerProperty logInAttempts , etc.
}