public class SecondActivity extends AppCompatActivity {
    private ListView lvContact;
    private Button addBtn,dleBtn;
    private PersonListAdapter adapter;
    private List<Person> mPersonList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //Error as creating a new object mPersonList which is local to onCreate()
        //Finally class variable mPersonList will be null still.

        //ArrayList<Person> mPersonList = new ArrayList<Person>(); //Logical Error 

        //Solution: Use class variable instead of creating a new variable. So, just replace the above commented line with below one.
        mPersonList = new ArrayList<Person>();

        addBtn = (Button) findViewById(R.id.update);

        ..... continue
    }