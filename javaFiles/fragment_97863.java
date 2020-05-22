public class MainActivity extends Activity {
SharedPreferences sharedpreferences;
public static final String MyPREFERENCES = "myprefs";
public static final  String value = "key";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    int i = sharedpreferences.getInt(value, 0);
    //use the value of i where needed.
}
public void saveMessage(View view) {
    i += 1;    
    SharedPreferences.Editor editor = sharedpreferences.edit();
    editor.putInt(value, i);
    editor.apply();
}