public class Main3Activity extends AppCompatActivity implements ViewClickCallBack {
    private RecyclerView recyclerView;
    private GridAdapter gridAdapter;
    private List<Model> models = new ArrayList<>();
    private final int SIZE_NEXT_ITEM = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView = (RecyclerView) findViewById(R.id.grid_recycle);
        gridAdapter = new GridAdapter(this);
        getNextModel();
        gridAdapter.setModels(models);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(gridAdapter);
    }

    @Override
    public void viewClicked(int position) {
        models.get(position - 1).setUploaded(true);// Set the upload flag as true for the clicked item
        int gridItemCount = gridAdapter.getItemCount();// Get the total count of items in gridview
        if ((gridItemCount - position) == 1) { // check if the clicked item is second last, if yes then difference would be 1

            getNextModel();
            gridAdapter.setModels(models);

        } else {
            Toast.makeText(this, "Popup Image picker", Toast.LENGTH_SHORT).show();
        }
        gridAdapter.notifyDataSetChanged();
    }

    /**
     * Function to get the set (or next set) of objects that
     * we want to show in GRID view.
     *
     * These objects will be added to a list.
     * This list will act as data source for adapter
     **/
    private void getNextModel() {
        for (int i = 0; i < SIZE_NEXT_ITEM; i++) {
            Model model = new Model();
            model.setUploaded(false);
            models.add(model);
        }

    }


}