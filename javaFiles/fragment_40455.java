public class secondActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondXML);
        Bundle myBundle = this.getIntent().getExtras(); //You got the bundle
        //TO USE THE BUNDLE
        String A = myBundle.getString("username"); // A = "Sherif"
        int B = myBundle.getInt("userid"); // B = 1234
    }
}