import auth.UserLevel;
import auth.UserType;

public class ControlService {
    @UserLevel(type=UserType.ADMIN)
    public String[] getUsers() {
        return new String[] {  };
    }

    @UserLevel(type=UserType.SYSTEM)
    public String[] getCommands() {
        return new String[] {  };
    }

    @UserLevel(type=UserType.GENERAL)
    public String[] getCategories() {
        return new String[] {  };
    }
}