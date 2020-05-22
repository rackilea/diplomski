public class MainActivity extends AppCompatActivity {
Button btn, btn2;
boolean isValid;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn = (Button) findViewById(R.id.button);
    btn2 = (Button) findViewById(R.id.button2);
    isValid = true;

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            isValid = true;
        }
    });

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            isValid = false;
        }
    });

  }
}