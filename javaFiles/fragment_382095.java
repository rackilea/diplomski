public class MainActivity extends AppCompatActivity {
Retrofit retrofit;
ApiService apiService;

String item1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //Log.i("result", getItemFromServer("5"));

    Log.i("msg", item1);

    String item2="item2";
    String item3="item3";

    ListView listView=(ListView)findViewById(R.id.listView);

    listView.setOnItemClickListener(
            new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                    String item=String.valueOf(parent.getItemAtPosition(i));
                    Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                }
            }
    );
    getItemFromServer("5");
}

public void getItemFromServer(String id){
    retrofit=new Retrofit.Builder().baseUrl(ApiService.API_URL).build();
    apiService=retrofit.create(ApiService.class);


    //GET
    Call<ResponseBody> comment=apiService.getByID(id);
    comment.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                item1=response.body().string();
            String[] items={item1, item2, item3};
            ListAdapter adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            listView.setAdapter(adapter);
            }catch (IOException e){
                Log.i("Test2", "failed");
            }
        }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.i("Test", "get item from server failed");
    }
});