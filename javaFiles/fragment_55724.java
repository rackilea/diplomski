import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    // These properties are used to display User data in the Scene
    private StringProperty username = new SimpleStringProperty();
    private StringProperty emailAddress = new SimpleStringProperty();

    /**
     * A simple constructor to build the User object with a username and email address
     */
    public User(String username, String emailAddress) {

        // Set the values for each of the User properties
        this.username.set(username);
        this.emailAddress.set(emailAddress);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getEmailAddress() {
        return emailAddress.get();
    }

    public StringProperty emailAddressProperty() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }
}