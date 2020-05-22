public class MainActivity extends AppCompatActivity {
    List<Feed> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable image = getDrawable(R.drawable.sample_image);
        mItems = Arrays.asList(new Feed("This is comment #1"),
                               new Feed("This is comment #2"),
                               new Feed(image),
                               new Feed("This is comment #3"),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed("This is comment #4"),
                               new Feed("This is comment #5"),
                               new Feed("This is comment #6"),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed("This is comment #7"),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed(image),
                               new Feed("This is comment #8"),
                               new Feed("This is comment #9")
        );
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}