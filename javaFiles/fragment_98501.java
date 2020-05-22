public class MainActivity extends AppCompatActivity {


RadioGroup radioGroup;
RadioButton radioButton1,radioButton2,radioButton3;
CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    radioGroup= (RadioGroup) findViewById(R.id.radio_group);
    radioButton1= (RadioButton) findViewById(R.id.button1);
    radioButton2= (RadioButton) findViewById(R.id.button2);
    radioButton3= (RadioButton) findViewById(R.id.button3);
    checkBox1= (CheckBox)findViewById(R.id.check1);
    checkBox2= (CheckBox)findViewById(R.id.check2);
    checkBox3= (CheckBox)findViewById(R.id.check3);
    checkBox4= (CheckBox)findViewById(R.id.check4);
    checkBox5= (CheckBox)findViewById(R.id.check5);
    checkBox6= (CheckBox)findViewById(R.id.check6);


    checkBox1.setEnabled(false);
    checkBox2.setEnabled(false);
    checkBox3.setEnabled(false);
    checkBox4.setEnabled(false);
    checkBox5.setEnabled(false);
    checkBox6.setEnabled(false);

    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);

            boolean isChecked = checkedRadioButton.isChecked();
            if (isChecked){
                checkBox1.setEnabled(true);
                checkBox2.setEnabled(true);
                checkBox3.setEnabled(true);
                checkBox4.setEnabled(true);
                checkBox5.setEnabled(true);
                checkBox6.setEnabled(true);
            }
        }
    });
}