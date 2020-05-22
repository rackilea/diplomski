public class MainActivity extends AppCompatActivity {

    TextView txdeleg_lista;
    Button btnObtener;
    ArrayList<String> arrayList = new ArrayList<String>();
    ListView listView;
    String json_url = "your url";
    ArrayAdapter<String> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnObtener = (Button) findViewById(R.id.btnObtener);
    txdeleg_lista = (TextView) findViewById(R.id.txdeleg_lista);
    listView = (ListView) findViewById(R.id.lvDelegacion);

    adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

    btnObtener.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //startActivity(new Intent(MainActivity.this, DesplegarLista.class));

            listView.setAdapter(adapter);


            request();

        }
    });
  }

  public void request() {
    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(json_url,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray jsonArray) {
                    Log.e("jsonArray",""+jsonArray);
                    if(jsonArray == null){
                        Toast.makeText(MainActivity.this,"EL JSONArray esta VACIO !!! ", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        for (int i = 0; i < jsonArray.length(); i++) {

                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String contact = jsonObject.getString("UFULLNAME");
                                arrayList.add(contact);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        adapter.notifyDataSetChanged();
                    }

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            Toast.makeText(MainActivity.this,"ERROR...", Toast.LENGTH_SHORT).show();
            error.printStackTrace();
        }
    });
    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
    requestQueue.add(jsonArrayRequest);
    }
}