public MyActivity extends Activity{
    public static String pageTitle = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sample);
        pageTitle = "abc";
    } 
}