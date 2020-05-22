public class SecondActivity extends Activity {

Button btnOne, btnTwo, btnThree;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    btnOne = (Button)findViewById(R.id.btnOne);
    btnTwo = (Button)findViewById(R.id.btnTwo);
    btnThree = (Button)findViewById(R.id.btnThree);

    // you dont need the names here, but maybe later
    String name1=getIntent().getStringExtra("name1");
    String name2=getIntent().getStringExtra("name2");
    String name3=getIntent().getStringExtra("name3");

    String number1=getIntent().getStringExtra("number1");
    String number2=getIntent().getStringExtra("number2");
    String number3=getIntent().getStringExtra("number3");

    btnOne.setText(number1);
    btnTwo.setText(number2);
    btnThree.setText(number3);

    btnOne.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+btnOne.getText()));
            startActivity(callIntent);
        }
    });

    btnTwo.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+btnTwo.getText()));
            startActivity(callIntent);
        }
    });

    btnThree.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+btnThree.getText()));
            startActivity(callIntent);
        }
    });
}