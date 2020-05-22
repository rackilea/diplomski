public class MainActivity extends AppCompatActivity {
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        timer = new CountDownTimer(...);
    }
}