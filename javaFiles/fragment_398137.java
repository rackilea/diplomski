public class MainActivity extends AppCompatActivity {

private Button btn1, btn2, btn3, btnC;
private EditText edit;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    edit = (EditText)findViewById(R.id.editText);
    btn1 = (Button)findViewById(R.id.btnOne);
    btn2 = (Button)findViewById(R.id.btnTwo);
    btn3 = (Button)findViewById(R.id.btnThree);
    btnC = (Button)findViewById(R.id.btnClear);


    View.OnClickListener cl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn1)
                edit.setText(edit.getText().toString() + 1);
            else if (v == btn2)
                edit.setText(edit.getText().toString() + 2);
            else if (v == btn3)
                edit.setText(edit.getText().toString() + 3);
            else if (v == btnC)
                edit.setText("");
            }
        };

        btn1.setOnClickListener(cl);

        btn2.setOnClickListener(cl);

        btn3.setOnClickListener(cl);

    }
}