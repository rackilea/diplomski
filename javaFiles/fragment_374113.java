public class MainActivity extends Activity{

    ActivityMainBinding binding; //Name of the layout in camel case + "Binding"

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvTest.setLayoutManager(layoutManager);
    }
}