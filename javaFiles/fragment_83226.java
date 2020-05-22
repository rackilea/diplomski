public class YourActivity extends Activity implements Button.OnClickListener {

         protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         Button ArsalButton = (Button)findViewById(R.id.ArsalButton);
         final TextView ArsalText = (TextView)findViewById(R.id.ArsalText);
         ArsalButton.setOnClickListener(this);

         }

         @Override
         public void onClick(View v) {
            // get view id and perform operation based on id.
         }
  }