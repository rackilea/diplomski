public class SecondActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.second_activity);

    User user = User.getInstance();

    TextView textView = (TextView) findViewById(R.id.textView2);
    textView.setText(user.toString());
}