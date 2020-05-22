public class MainActivity extends AppCompatActivity {

private EditText editText1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editText1=findViewById(R.id.editText1);
    Editable decimalNumber=editText1.getText();
   }
}