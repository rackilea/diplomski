public class MainActivity extends AppCompatActivity {

    private static final int NUMBER_COLUMNS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, NUMBER_COLUMNS));
        recyclerView.addItemDecoration(new SampleItemDecoration());
        final MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

        // Items can be added to adapter from any part of code
        adapter.addItem("Static Item A");
        adapter.addItem("Static Item B");


        findViewById(R.id.button_add_item).setOnClickListener(new View.OnClickListener() {
            int i;

            @Override
            public void onClick(View v) {
                adapter.addItem("Dynamic Item " + i++);
            }
        });
    }
}