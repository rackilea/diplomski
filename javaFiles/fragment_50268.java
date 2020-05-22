public class MainActivity extends AppCompatActivity {

    TextView mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessage = this.findViewById(R.id.message);

        // Immediately start Login Activity
        Intent i = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMessage.setText("Welcome back");
    }
}