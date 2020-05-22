public class MainActivity extends AppCompatActivity 
    implements View.OnClickListener {

    TextView tabela;
    EditText number;
    Button b;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            String written = number.getText().toString();
            km = Double.parseDouble(written);
            tabela.setText("Total Amount" + ((km*x)+y));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabela = (TextView) findViewById(R.id.tabela);
        number = (EditText) findViewById(R.id.number);

        b = ... // find button here
        b.setOnClickListener(this); // to the activity