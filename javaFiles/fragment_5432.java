public class MainActivity extends AppCompatActivity {
Button btn, btn2;
RadioGroup radioButtonGroup;
RadioButton selected;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn = (Button) findViewById(R.id.button);
    btn2 = (Button) findViewById(R.id.button2);
    radioButtonGroup = (RadioGroup) findViewById(R.id.rad);
    boolean isValid = false;
    btn.setOnClickListener(new View.OnClickListener() {
        RadioButton rad;
        @Override
        public void onClick(View v) {
            if(selected != null) {
                selected.setTextColor(Color.BLACK);

            }
            int selectedId = radioButtonGroup.getCheckedRadioButtonId();
            selected = (RadioButton) findViewById(selectedId);
            selected.setTextColor(Color.GREEN);
        }
    });

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(selected != null) {
                selected.setTextColor(Color.BLACK);

            }
            int selectedId = radioButtonGroup.getCheckedRadioButtonId();
            selected = (RadioButton)findViewById(selectedId);
            selected.setTextColor(Color.RED);
        }
    });
  }
}