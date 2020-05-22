public class MainActivity extends AppCompatActivity {

IntDataBaseHelper intDataBaseHelper;
ArrayAdapter<String> mAdapter;
ListView lstJob;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.header);