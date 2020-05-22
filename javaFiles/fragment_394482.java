public abstract class User {
    private int age;
    private int id;

    public int getAge() { return age; }
    public int getId() { return id; }
}


public class User1 extends User { }
public class User2 extends User { }

User user1 = new User1();
user1.getId();
User user2 = new User2();
user2.getId();