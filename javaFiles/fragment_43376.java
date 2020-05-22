public class Celfahr extends Activity {
    private double celsius = 0.0;
    private double fahrenheit = 0.0;
    private EditText celsiuskentta;
    private EditText fahrenheitkentta;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button celsiusasteiksi = (Button) findViewById(R.id.celsiusasteiksi);
        Button fahrenheiteiksi = (Button) findViewById(R.id.fahrenheitasteiksi);
        celsiuskentta = (EditText) findViewById(R.id.celciuskentta);
        fahrenheitkentta = (EditText) findViewById(R.id.fahrenheitkentta)

        celsiusasteiksi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fahrenheit = Double.parseDouble(fahrenheitkentta.getText().toString());         
                celsiuskentta.setText(String.valueOf(pyorista((fahrenheit - 32) / 1.8)));
            }
        });

        fahrenheiteiksi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                celsius = Double.parseDouble(celsiuskentta.getText().toString());   
                fahrenheitkentta.setText(String.valueOf(pyorista(celsius * 1.8 + 32)));
            }
        });
    }    
...