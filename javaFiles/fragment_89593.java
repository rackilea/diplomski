public class Menu extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);

    ImageView imgview = (ImageView) findViewById(R.id.table);
    imgview.bringToFront();
    imgview.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(Menu.this, Options.class);
            startActivity(myIntent);
        }
    });
 }
}