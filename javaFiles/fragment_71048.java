public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs =
                        getSharedPreferences("StorageName", MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();
                //The value type determines the "put" in your case break the
                //array into a for statement and save each value
                for (String s : myArray) {
                    //s would be the value
                    //make a key for your stored value just like a HashMap
                    editor.putString(key, value).apply();

                }

            }
        });
        t.start();
    }
 }