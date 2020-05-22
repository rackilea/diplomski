public class User {
    String id,pw;
    char type;
    public User(String id, String pw, char type) {
        super();
        this.id = id;
        this.pw = pw;
        this.type = type;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", pw=" + pw + ", type=" + type + "]";
    }
}

public class UserDB {
    User[] userAry;

    public UserDB() {
        userAry = new User[0];
    }

    public void addUser(String id, String pw, char type) {
        User[] newUserAry = new User[userAry.length + 1];
        System.arraycopy(userAry, 0, newUserAry, 0, userAry.length);
        newUserAry[newUserAry.length - 1] = new User(id, pw, type);
        userAry = newUserAry;
    }
    public void printList() {
        for (User user:userAry)
            System.out.println(user);
    }
}

public class TestUserDB {
    public static void main(String[] args) {
        UserDB db=new UserDB();
        db.addUser("a1", "a", 'a');
        db.addUser("a2", "b", 'b');
        db.addUser("a3", "c", 'a');
        db.addUser("a4", "d", 'b');

        db.printList();
    }
}