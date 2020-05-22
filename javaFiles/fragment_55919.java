public class MainActivity extends Activity {
           private LinearLayout mainLayout;
           private String[] values = {"Hello", "Java", "Android"};
           private String[] values2 = {"Hmmm", "OK", "Bye"};
           private MyViewController myViewController;

           @Override
           protected void onCreate(Bundle savedInstanceState) {
                  super.onCreate(savedInstanceState);
                  setContentView(R.layout.activity_main);
                  mainLayout = (LinearLayout) findViewById
                            (R.id.main_linear_layout);
                  myViewController = new MyViewController(this);
                  LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                  params.setMargins(0, 5, 0, 5);
                  for (int i = 0; i < 10; ++i) {
                        Spinner spin = myViewController.getSpinner();
                        ArrayAdapter adapter;
                        if (i % 2 == 0) {
                          adapter = myViewController.getAdapter(R.layout.my_custom_style, values);
                        } else {
                          adapter = myViewController.getAdapter(R.layout.my_custom_style, values2);
                        }
                        spin.setAdapter(adapter);
                        mainLayout.addView(spin, params);
                  } 

           }
    }