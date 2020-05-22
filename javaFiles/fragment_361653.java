public class MainActivity extends ActionBarActivity {

    private EditText a1;
    private EditText b1;
    private EditText c1; 
    private EditText d1; 
    private TextView tv;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pola
        a1 = (EditText) findViewById(R.id.cel);
        b1 = (EditText) findViewById(R.id.pali);
        c1 = (EditText) findViewById(R.id.litr);
        d1 = (EditText) findViewById(R.id.koszt);

        // wynik
        tv = (TextView) findViewById(R.id.wynikKoszt);
        tv2 = (TextView) findViewById(R.id.wynikKilometry);

        findViewById(R.id.button).setOnClickListener(onClickListener);
        findViewById(R.id.button2).setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            float a = 0;
            float b = 0;
            float c = 0;
            float d = 0;
            float wynik = 0;

            try {
                a = Float.parseFloat(a1.getText().toString());
                b = Float.parseFloat(b1.getText().toString());
                c = Float.parseFloat(c1.getText().toString());
                d = Float.parseFloat(d1.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (view.getId() == R.id.button) {
                wynik = ((b / 100) * a) * c;
                tv.setText(String.valueOf(wynik));
            } else if (view.getId() == R.id.button2) {

                if((b * c == 0)){
                    Toast.makeText(MainActivity.this, "You can't divide by 0", Toast.LENGTH_LONG).show();
                    return;
                }

                wynik = d / ((b * c) / 100);
                tv2.setText(String.valueOf(wynik));
            }
        }
    };
}