package stackoverflow.questions.q19966529;

import java.util.*;

import com.google.gson.Gson;

public class Q19966529 {

    public static class User{
        Long userId;
        String userName;
        String displayName;

        public User(Long userId, String userName, String displayName){
            this.userId = userId;
            this.userName = userName;
            this.displayName = displayName;             
        }
    }

    public static class UserList{
        private List<User> list = new ArrayList<>(); //java 7 
        private int count = 0;

        public void addUser(User u){
            list.add(u);
            count = list.size();

        }
    }

    public static void main(String[] args) {

        UserList ul = new UserList();
        ul.addUser(new User(149L, "jack0231", "Jackie"));
        ul.addUser(new User(301L, "helms_mighty", "Hippoman"));

        String json = new Gson().toJson(ul);
        System.out.println(json);
    }

}