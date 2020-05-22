public class MainActivity extends AppCompatActivity {

private RecyclerView recyclerView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

    //Just your list of objects, in your case the list that comes from the db
    List<Items> itemsList = new ArrayList<>();
    CardAdapter adapter = new CardAdapter(this, itemsList);

    //RecyclerView needs a layout manager in order to display data so here we create one
    StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

    //Here we set the layout manager and the adapter to the listview
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
}