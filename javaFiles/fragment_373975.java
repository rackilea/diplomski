public class Menu extends AppCompatActivity {
String username;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
    username = getIntent().getStringExtras("Username");
}

public void addReminder(View v) {
    Intent intent = new Intent(this, AddReminder.class);
    intent.putExtra("Username", username);
    startActivity(intent);
}
}