@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_telephones,container,false);

    listView = (ListView) view.findViewById(R.id.listview1);
    adapter = new TelAdapter(getActivity(), data);
    listView.setAdapter(adapter);
    progressDialog = new ProgressDialog(getActivity());
    progressDialog.setMessage("please wait");
    progressDialog.show();
    telfilter = (EditText) view.findViewById(R.id.myFilter);
    telfilter.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


            List<tel_list> temp = new ArrayList<tel_list>();

            String input = s.toString();

            for (int i = 0; i < data.size(); i++) {
                tel_list item = data.get(i);

                String name = item.getName();
                String number = item.getNumber();

                if (name.contains(input) || number.contains(input)) {
                    temp.add(item);
                }
            }

            adapter.setTelephones(temp);
            adapter.notifyDataSetChanged();

        }


        @Override
        public void afterTextChanged(Editable s) {


        }

    });

    requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://abood250.com/alruthea/getphones.php",
            new com.android.volley.Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    hideprogressDialog();

                    try {

                        JSONArray jsonArray = response.getJSONArray("telephones");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject telephones = jsonArray.getJSONObject(i);
                            tel_list tellist = new tel_list();

                            tellist.setName(telephones.getString("name"));
                            tellist.setNumber(telephones.getString("number"));

                            data.add(tellist);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    adapter.notifyDataSetChanged();
                }
            },

            new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    hideprogressDialog();

                    Log.e("Volley", "Error");
                }
            }


    );

    requestQueue.add(jsonObjectRequest);

    return view;
}