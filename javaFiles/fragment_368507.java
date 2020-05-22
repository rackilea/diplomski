public class MainActivity extends AppCompatActivity {

    //Interface callback here
    interface RevealDetailsCallbacks {
        public void getDataFromResult(List<String> details);
    }

    //Keep your same variables here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Same setup here

        this.callback = new RevealDetailsCallbacks() {
            @Override
            public void getDataFromResult(List<String> details) {
                //Do stuff here with the returned list of Strings
            }
        };


        fab_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Same setup here, then call the method
                makeWebCalls();
            }
        });

    }

    private void makeWebCalls(){
        Call<List<Patient>> call = api.getPatients();
        models = lists[0];
        call.enqueue(new Callback<List<Patient>>() {
            @Override
            public void onResponse(Call<List<Patient>> call, Response<List<Patient>> response) {
                //Run your response code here. When done, pass to the callback
            }

            @Override
            public void onFailure(Call<List<Patient>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}