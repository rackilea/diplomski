public class MyGameActivity extends AndroidApplication implements NativeFunctions {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new MyGame(this), false);
    }
    public void openURL(String url) {
        Intent viewIntent = new Intent("android.intent.action.VIEW", 
            Uri.parse(url));
        startActivity(viewIntent);  
    }
}