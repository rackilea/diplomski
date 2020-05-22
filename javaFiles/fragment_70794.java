public class MainActivity extends AppCompatActivity implements EntryAdapter.OnAdapterClick {

    EntryAdapter entryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entryAdapter = new EntryAdapter(list, this);
        recyclerView.setAdapter(entryAdapter);

    }

    @Override
    public void OnItemClicked(View v, int position) {
       Entry itemClicked = entryAdapter.getItemViewType(position);
       int id = itemClicked.getId();
    }
}