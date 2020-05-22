Preferences prefs = Preferences.userNodeForPackage(this);
String prefWindow = prefs.get("PREF_WIND",null);
if (prefWindow!=null) {
    LoginWindow loginWindow = LoginWindow.valueOf(prefWindow);
    switch(loginWindow) {
    case ADMIN:
         // switch to admin
         break;
    case CLIENT:
         // switch to client
         break;
    }
} else
    // Default