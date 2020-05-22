public class TerbaruSimasCard extends Activity {

    private ProgressDialog dialog;
    private ArrayList<TerbaruModel> ListTerbaru =  null;
    private ArrayList<ChildTerbaru> ListChildTerbaru =  null;
    private ArrayList<ArrayList<ChildTerbaru>> ListChildXXXXXXXXX = null;
    ListView list;
    String phone1, begdate1, enddate1, img_id1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
        ListTerbaru = new ArrayList<TerbaruModel>();
        ListChildTerbaru = new ArrayList<ChildTerbaru>();//ArrayList<ArrayList<ChildTerbaru>>>();
        ListChildXXXXXXXXX = new ArrayList<ArrayList<ChildTerbaru>>();
        new TerbaruAsyncTask().execute();
    }

    public class TerbaruAsyncTask extends AsyncTask<Void, Void, String> {
        String url = ("http:www.domain.com/123");

        public TerbaruAsyncTask() {
            this.url = url;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(TerbaruSimasCard.this, "",
                    "melakukan pengambilan data...");
        }

        @Override
        protected String doInBackground(Void... params) {
            String result = "";
            try {
                result = Connection.get(url);
            } catch (Exception e) {
                result = "";
                Log.d("test", e.getMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            fetchResponse(result.replace("\n", "").trim());
            dialog.dismiss();
        }

    }

    private void fetchResponse(String result) {
        if (!result.equals("")) {
            try {
                JSONArray jsonArray = new JSONArray(result);
                TerbaruModel LT = null;
                ChildTerbaru CT = null;
                for (int i = 0; i < jsonArray.length(); i++) {
                    ListChildTerbaru = new ArrayList<ChildTerbaru>();
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    LT = new TerbaruModel(jsonObject.optString("img_id"),
                            jsonObject.optString("nama"),
                            jsonObject.optString("alamat"));
                    ListTerbaru.add(LT);

                    //for (int j = 0; j < jsonArray.length(); j++) {
                        CT = new ChildTerbaru(jsonObject.optString("begdate"),
                                jsonObject.optString("enddate"));
                        ListChildTerbaru.add(CT);//get(i).get(i).add(CT);

                    //}
                        ListChildXXXXXXXXX.add(ListChildTerbaru);
                    ExpandableListView list = (ExpandableListView) findViewById(R.id.expandablelistView);

                    TerbaruAdapter adapter = new TerbaruAdapter(this,ListTerbaru, ListChildXXXXXXXXX);
                    list.setAdapter(adapter);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}