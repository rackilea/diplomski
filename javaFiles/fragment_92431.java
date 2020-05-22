import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class GlobalData {

    // Global property to hold the currently-selected user
    private ObjectProperty<User> selectedUser = new SimpleObjectProperty<>();

    private static GlobalData ourInstance = new GlobalData();

    public static GlobalData getInstance() {
        return ourInstance;
    }

    private GlobalData() {
    }

    public User getSelectedUser() {
        return selectedUser.get();
    }

    public ObjectProperty<User> selectedUserProperty() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser.set(selectedUser);
    }
}