public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<Request> requests;
    private  ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = binding.recyclerView;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Request>> call = apiInterface.getRequests();
        call.enqueue(new Callback<List<Request>>() {
            @Override
            public void onResponse(@NonNull Call<List<Request>> call, @NonNull Response<List<Request>> response) {
                requests = response.body();
                recyclerAdapter = new RecyclerAdapter(MainActivity.this, requests);
                recyclerView.setAdapter(recyclerAdapter);
            }
            @Override
            public void onFailure(@NonNull Call<List<Request>> call, @NonNull Throwable t) {}
        });
        binding.setOnReqCall(this);
    }
    public void onNewReqClick(){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.new_request);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
}