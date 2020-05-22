public class UserDetails{
static final String SharedPrefUserName = ""; //default value can go in between " ".
static final String SharedPrefUserOtherData = ""; 

//the bit below gets the shared preferences
public static SharedPreferences getSharedPreferences(Context ctx)
{
    return PreferenceManager.getDefaultSharedPreferences(ctx);
}

//This sets a string value
public static void setLoggedInUserName(Context ctx, String name)
{
    SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
    editor.putString(SharedPrefUserName, name);
    editor.commit();
}

//this retrieves a string value
public static String getLoggedInUserName(Context ctx)
{
    return getSharedPreferences(ctx).getString(SharedPrefUserName, "");
}


}