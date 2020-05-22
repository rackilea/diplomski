public class MainActivity extends Activity {
    // Declare Variables
    JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    Adapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    ArrayList<String> arraylist2;
    static String NAME = "rank";
    Button btn;

    StringBuilder result;

    MyApplication mapp;//get MyApplication reference

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.activity_main);
        arraylist = new ArrayList<HashMap<String, String>>();
        arraylist2 = new ArrayList<String>();
        mapp=MyApplication.getInstance();


        listview = (ListView) findViewById(R.id.listView);
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
             // Toast.makeText(MainActivity.this,"///"+arraylist.size(), 1000).show();
                result = new StringBuilder();
                for (int i = 0; i < arraylist.size(); i++) {
                    if (adapter.mysparse.get(i) == true) {

                        result.append(arraylist.get(i).get(MainActivity.NAME));
                        arraylist2.add(arraylist.get(i).get(MainActivity.NAME));
                        result.append("\n");
                    }

                }
                mapp.setArrayListMapData(arraylist2);
                Toast.makeText(MainActivity.this,result, 1000).show();
                Intent n = new Intent(MainActivity.this, DisplayActivity.class);
               // n.putExtra("buffer", arraylist2);
                startActivity(n);
            }
        });

        // Execute DownloadJSON AsyncTask
        new DownloadJSON().execute();
    }

    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MainActivity.this);
            // Set progressdialog title
            // mProgressDialog.setTitle("Fetching the information");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create an array

            try {
            // Retrieve JSON Objects from the given URL address
            String s = getData();
            jsonobject = new JSONObject(s);


                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("restaurants");

                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put(MainActivity.NAME,
                            jsonobject.getString("Person_Name"));
                    Log.d("jsonobject", jsonobject.toString());
                    // Set the JSON Objects into the array
                    arraylist.add(map);
                }
            } catch (JSONException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Pass the results into ListViewAdapter.java
            adapter = new Adapter(MainActivity.this, arraylist);


            // Set the adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }


        private String getData() {
            String _response = null;
            try
            {
            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
            HttpGet request = new HttpGet("http://54.218.73.244:7004/DescriptionSortedPrice/");
            HttpResponse response = httpclient.execute(request);
            HttpEntity resEntity = response.getEntity();
             _response =EntityUtils.toString(resEntity);

            }
            catch(Exception e)
            {
                  e.printStackTrace();  
            }

            return _response;
        }
        public class Adapter extends BaseAdapter implements OnCheckedChangeListener {

            // Declare Variables
            Context context;
            LayoutInflater inflater;
            ArrayList<HashMap<String, String>> data;
            HashMap<String, String> resultp = new HashMap<String, String>();
            SparseBooleanArray mysparse;

            public Adapter(Context context, ArrayList<HashMap<String, String>> arraylist) {
                this.context = context;
                data = arraylist;
                mysparse = new SparseBooleanArray(data.size());
            }

            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            public View getView(final int position, View convertView, ViewGroup parent) {
                // Declare Variables
                TextView name;
                CheckBox chk;

                inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View itemView = inflater.inflate(R.layout.single_item, parent, false);
                // Get the position
                resultp = data.get(position);

                // Locate the TextViews in listview_item.xml
                name = (TextView) itemView.findViewById(R.id.textView1);
                chk = (CheckBox) itemView.findViewById(R.id.checkBox1);

                // Capture position and set results to the TextViews
                name.setText(resultp.get(MainActivity.NAME));

                chk.setTag(position);
                chk.setChecked(mysparse.get(position, false));
                chk.setOnCheckedChangeListener(this);

                return itemView;
            }

            public boolean isChecked(int position) {
                return mysparse.get(position, false);
            }

            public void setChecked(int position, boolean isChecked) {
                mysparse.put(position, isChecked);

            }

            public void toggle(int position) {
                setChecked(position, !isChecked(position));

            }

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                mysparse.put((Integer) buttonView.getTag(), isChecked);
            }
        }
    }