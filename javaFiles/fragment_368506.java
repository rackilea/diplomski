public class MainActivity extends AppCompatActivity {

    //Interface callback here
    interface RevealDetailsCallbacks {
        public void getDataFromResult(List<String> details);
    }

    EditText et_message;
    FloatingActionButton fab_send;
    API api;
    ListView list_view_conversation;
    List<ChatModel> list_chat = new ArrayList<>();
    RevealDetailsCallbacks callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_message = (EditText) findViewById(R.id.et_message);
        fab_send = (FloatingActionButton) findViewById(R.id.fab_send);
        list_view_conversation = (ListView) findViewById(R.id.list_view_conversation);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.callback = new RevealDetailsCallbacks() {
            @Override
            public void getDataFromResult(List<String> details) {
                //Do stuff here with the returned list of Strings
            }
        };

        api = retrofit.create(API.class);

        fab_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //this method ultimately is to get response and send back to user
                String s = et_message.getText().toString();
                ChatModel model = new ChatModel(s, true);
                list_chat.add(model);
                new retrieveDetails(callback).execute(list_chat);

                et_message.setText("'");
            }
        });

    }

    public class retrieveDetails extends AsyncTask<List<ChatModel>, Void, String> {
        String text = et_message.getText().toString();
        String mainReply = "";
        List<ChatModel> models;
        List<String> details = new ArrayList<String>();
        private RevealDetailsCallbacks listener;

        retrieveDetails(RevealDetailsCallbacks listener){
            this.listener = listener;
        }

        @Override
        public String doInBackground(final List<ChatModel>[] lists) {
            Call<List<Patient>> call = api.getPatients();
            models = lists[0];
            call.enqueue(new Callback<List<Patient>>() {
                public String reply;

                @Override
                public void onResponse(Call<List<Patient>> call, Response<List<Patient>> response) {
                    List<Patient> patients = response.body();

                    for (int i = 0; i < patients.size(); i++) {
                        if (patients.get(i).getNric().equals(text)) {
                            details.add("Name: " + patients.get(i).getName() + "\nNRIC: " + patients.get(i).getNric()
                                    + "\nDOB: " + patients.get(i).getDob() + "\nContact No: " + patients.get(i).getContactno());
                        }
                    }
                    this.mainReply = details.get(0);
                    Log.i("Here Log i", reply);
                    if(listener != null) {
                        listener.getDataFromResult(details);
                    }
                }

                @Override
                public void onFailure(Call<List<Patient>> call, Throwable t) {
                    //Don't make a toast here, it will throw an exception due to it being in doInBackground
                    //Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            return mainReply;//I want to reply with the data added into the details arraylist in the onResponse segment
        }


        @Override
        public void onPostExecute(String s) {
            ChatModel chatModel = new ChatModel(s, false);
            models.add(chatModel);
            CustomAdapter adapter = new CustomAdapter(models, getApplicationContext());
            list_view_conversation.setAdapter(adapter);
        }
    }
}