import java.util.Collections;
import java.util.List;

public class UserDemo {

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("Jim", 4398));
        users.add(new User("James", 9880));
        users.add(new User("Jane", 10238));
        users.add(new User("Jack", 5498));
        users.add(new User("Josh", 6530));
        users.add(new User("John", 12349));
        users.add(new User("Jim", 9438));
        users.add(new User("Jill", 12307));
        users.add(new User("Jimbo", 23454));
        users.add(new User("Jason", 5430));

        Collections.sort(users);

        for (User user : users) {
            System.out.println(user);
        }
    }
}