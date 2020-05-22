public class Main extends Activity{

protected void onCreate(Bundle savedInstanceState){
    \\setup rest here. 

SharedPreferences share_someting = PreferenceManager.getDefaultSharedPreferences(this);
String ss = share_something.getString("prefSyncFrequency", "Double");
}

protected void onResume(){
 \\setup rest here.
SharedPreference share_something = PreferenceManager.getDefaultSharedPrefernce(this);
String ss = share_something("prefSyncFrequency", "Double");
}