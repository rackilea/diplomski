public void MyActivity extends Activity {
     TextView textView;
     MyButton myButton;

     @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main)

         textView = (TextView) findViewById(R.id.textBtn);
         myButton = (MyButton) findViewById(R.id.myBtn);

         myButton.setOnClickListener(new OnClickListener() {
              @Override
              public void onClick(View v) {
                  textView.setText("It Works!");
              }
         }
     }