import java.util.prefs.Preferences;

public class DemoApplication {
  Preferences preferences = 
      Preferences.userNodeForPackage(DemoApplication.class);

  public void setCredentials(String username, String password) {
    preferences.put("db_username", username);
    preferences.put("db_password", password);
  }

  public String getUsername() {
    return preferences.get("db_username", null);
  }

  public String getPassword() {
    return preferences.get("db_password", null);
  }

  // your code here
}