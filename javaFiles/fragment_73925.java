import java.util.ArrayList;
import java.util.List;


public class Test {
    public static List<User> getUsers() {
        ArrayList<User> usersList = new ArrayList<User>();
        for(int i=1;i<=100;i++) {
            User user = new User();
            user.setFirstName("firstName_+"+i);
            user.setLastName("lastName_+"+i);
            user.setCity("city_+"+i);
            usersList.add(user);
        }
        return usersList;
    }
}