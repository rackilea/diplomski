public class MainActivity extends AppCompatActivity {

    MultiUserDBHelper dbuser1, dbuser2, dbuser3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbuser1 = new MultiUserDBHelper(this,"User1");
        dbuser2 = new MultiUserDBHelper(this,"User2");
        dbuser3 = new MultiUserDBHelper(this,"User3"); 
    }
}