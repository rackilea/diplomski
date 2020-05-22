public class MainActivity extends AppCompatActivity {        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);            
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://ppcinj.com?action=login&username=michael&password=qwerty123")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {                    
                Log.e("BNK", e.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {                    
                Log.i("BNK", response.toString());
            }
        });
    }
}