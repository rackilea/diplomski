public class CustomClassDemoActivity extends CustomActivity{
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button) findViewById(R.id.myTextView);
        button.setText("This is a Custom Activity Example");
        super.initLayout(button);
        simple_method();
    }

    public void simple_method(){
        super.simple_method();
        System.out.println("test in mainClass");
    }
    @Override
    public void onClick(View v) {
        super.onClick(v);
        Toast.makeText(getApplicationContext(), "Button Clicked in Main Activity", Toast.LENGTH_LONG).show();
    }
}