public class SampleApplication extends Application {

private static String username;
private static String password;

@Override
public void onCreate() {
super.onCreate();
username="";
password="";
}

public static String getUsername() {
return username;
}

   public static void setUsername(String username) {
   SampleApplication.username = username;
}

public static String getPassword() {
    return password;
}

public static void setPassword(String password) {
    SampleApplication.password = password;
}


}