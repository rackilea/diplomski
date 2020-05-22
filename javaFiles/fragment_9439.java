public class MainActivity extends AppCompatActivity {

            int counterint;
            TextView counter;
            String stringnumber;
            SharedPreferences sharedPreferences;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
    counter = findViewById(R.id.countertv);
        sharedPreferences = this.getSharedPreferences("com.example.hugelon", Context.MODE_PRIVATE);

                stringnumber=String.valueOf(sharedPreferences.getInt("hugcounter", 0));
counter.setText(stringnumber);
            }


            public void hughim(View view){

                counter = findViewById(R.id.countertv);

                stringnumber = counter.getText().toString();
                counterint = Integer.parseInt(stringnumber);
                counterint++;
                counter.setText(Integer.toString(counterint));

                sharedPreferences.edit().putInt("hugcounter", counterint);

            }

        }