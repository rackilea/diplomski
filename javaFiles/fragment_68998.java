public class SortPersonsActivity extends AppCompatActivity {

    private List<Person> mPersons;

    private SortPersonsAdapter mPersonsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPersons = new ArrayList<>();
        mPersons.add(new Person("1\nrank", "James Kub"));
        mPersons.add(new Person("2\nrank", "Peter Hanly"));
        mPersons.add(new Person("3\nrank", "Josh Penny"));
        mPersons.add(new Person("1\nrank", "Danny Jackson"));
        mPersons.add(new Person("3\nrank", "Brad Black"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lst_items);
        recyclerView.setLayoutManager(getLayoutManager());
        mPersonsAdapter = new SortPersonsAdapter(this, mPersons);
        recyclerView.setAdapter(mPersonsAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // building new fake person
                Person person = new Person(
                        buildRandomInt(10) + "\nrank",
                        buildRandomName(5) + " " + buildRandomName(5));
                // let's keep also basic list updated
                mPersons.add(person);
                // let's update adapter
                mPersonsAdapter.addPerson(person);
            }
        });
    }

    private RecyclerView.LayoutManager getLayoutManager() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        return llm;
    }

    // support method for random names and ranks here

}