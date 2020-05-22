public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final String passwordA = "root";

            EditText editText = (EditText) findViewById(R.id.editText);
            Button button = (Button) findViewById(R.id.button);
            TextView textView2 = (TextView) findViewById(R.id.textView2);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

               textView2.setText(editText.getText().toString().trim());
                    if(editText.getText().toString().trim().equals(passwordA)){
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(i);
                    }else{
                    // Do what you want when password is not matches.
                    }
                }
            });
        }
    }