public class MainActivity extends Activity 
{
private EditText myEditField;
private EditText myEditField2;
private Button enter;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    myEditField = (EditText) findViewById(R.id.percentText);
    myEditField2 = (EditText) findViewById(R.id.billText);
    enter = (Button)findViewById(R.id.button1);

    enter.setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
            TextView textView;

            textView = (TextView) findViewById(R.id.textView1);

            final EditText myEditField = (EditText) findViewById(R.id.percentText);
            final EditText myEditField2 = (EditText) findViewById(R.id.billText);

            float percentage;//=======> declate as float
            int percentageInp;
            int billAmount;
            int output; 
            String output1;

            percentageInp = Integer.parseInt(myEditField.getText().toString());
            billAmount = Integer.parseInt(myEditField2.getText().toString());

            System.out.println(percentageInp+" "+billAmount);

            percentage = ((float)percentageInp /100);//=====>check here

            output = (int)(billAmount * percentage);
            output1 = Integer.toString(output);

            textView.setText(output1);

        }
    });
}
}