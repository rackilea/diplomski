public class AddReminder extends AppCompatActivity {
String item;
String username;
//Passing Value Through String
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_reminder);
    EditText edtItem= (EditText)findViewById(R.id.edtitem);
    item=edtItem.getText().toString();
    username = getIntent().getStringExtras("Username");
}

public void AddEventPlace(View v){
    Intent intent = new Intent(this, AddEventPlace.class);
    intent.putExtra("Username", username);
    intent.putExtra("item",item);
    startActivity(intent);
}
}