public class TabMoreHotActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragmentmore_tabhot);

    AdapterMoreSectionHotTrendingNews adapterMoreSectionHotTrendingNews;
    // here you have to initialize it 
    ArrayList<ModelSectionHotTrendingNews> modelSectionHotTrendingNews = new ArrayList<>();
    Bundle bundle = getIntent().getExtras();
    if(bundle!=null)
    {
        modelSectionHotTrendingNews = (ArrayList<ModelSectionHotTrendingNews>) bundle.getSerializable("MoreNews");
    }


    //1
    RecyclerView RecyclerViewMoreSingleHotTrendingNews = findViewById(R.id.RecyclerViewMore_Single_HotTrendingNews);
    RecyclerViewMoreSingleHotTrendingNews.setHasFixedSize(true);
    adapterMoreSectionHotTrendingNews = new AdapterMoreSectionHotTrendingNews(this, modelSectionHotTrendingNews);

    // here have to set layout manager before set adapter
    RecyclerViewMoreSingleHotTrendingNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    // and then you have to set adapter to recyclerview 
 RecyclerViewMoreSingleHotTrendingNews.setAdapter(adapterMoreSectionHotTrendingNews);




    //Optimized
    RecyclerViewMoreSingleHotTrendingNews.setHasFixedSize(true);
    RecyclerViewMoreSingleHotTrendingNews.setItemViewCacheSize(20);
   }
}