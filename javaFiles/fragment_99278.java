public class UserLocalStore {
    public int x = 0;
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;
    public int currentID;
    public  UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);

    }
    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        //spEditor.putString("ID", Integer.toString(x));
        spEditor.putString(Integer.toString(x) +" name", user.name);
        spEditor.putString(Integer.toString(x) +" username", user.username);
        spEditor.putString(Integer.toString(x) +" password", user.password);
        x++;
        spEditor.commit();

    }
    public int getByUsername(String findusername){
        int x = 0;

        while(x < 10){
            String test = userLocalDatabase.getString(Integer.toString(x)+ " username", "");
        if(test.equals(findusername)){

            String name = userLocalDatabase.getString(Integer.toString(x)+" name", "");
            String username = userLocalDatabase.getString(Integer.toString(x)+" username", "");
            String password = userLocalDatabase.getString(Integer.toString(x)+" password", "");
            User foundUser = new User(name,username,password);
            return x;
        }
            x++;
        }


        return 0;
    }

    public ArrayList<User> getAllUsers(){
        int x = 0;
        ArrayList<User> allUsers = new ArrayList<>();
        User tempuser = new User("","","");
        while(x < 10) {
            if(userLocalDatabase.getString(Integer.toString(x) + " name", "").equals("")) {
            return allUsers;
            }
            String name = userLocalDatabase.getString(Integer.toString(x) + " name", "");
            String username = userLocalDatabase.getString(Integer.toString(x) + " username", "");
            String password = userLocalDatabase.getString(Integer.toString(x) + " password", "");
            tempuser.name = name;
            tempuser.username = username;
            tempuser.password = password;
           allUsers.add(tempuser);
            x++;
        } return allUsers;

    }

    public User getLoggedInUser(int ID){
        String name = userLocalDatabase.getString(Integer.toString(ID)+" name", "");
        String username = userLocalDatabase.getString(Integer.toString(ID)+" username", "");
        String password = userLocalDatabase.getString(Integer.toString(ID)+" password", "");

        User storedUser = new User(name,username,password);
        return  storedUser;
    }
    public User getStoredPreferences(){
        String name = userLocalDatabase.getString("name", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");

        User storedUser = new User(name,username,password);
        return  storedUser;
    }


    public void setUserLoggedIn(int loggedIn){
        currentID = loggedIn;
      }

    public int getUserLoggedIn() {
        return currentID;
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();


    } }