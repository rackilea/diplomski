import java.util.ArrayList;
import java.util.Arrays;

public class Array_MultiDimentional2 {
    public static void main(String[] args) {
        String[][] users;
        String email = null;
        String name = null;
        String pass = null;
        users = new String[][] {{"email", "name", "pass" }, {"one", "two", "three"}};
        //System.out.println("users=" + users);
        System.out.println(Arrays.deepToString(users));
    }
}