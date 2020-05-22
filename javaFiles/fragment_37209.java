@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
String item = (String) getListAdapter().getItem(position);

/**get the intent*/
Intent studentIntent = getIntent();

/**retrieve the data extra passed*/
ArrayList<String> names = new ArrayList<String>();
ArrayList<String> grades = new ArrayList<String>();
JSONObject json_data = new JSONObject();
try {
    JSONArray jARR = new JSONArray(getIntent().getStringExtra("data"));
    Log.i("json review:", "Check out my JSON, looks like his JMother");
    for(int i=0;i<jARR.length();i++){
        json_data = jARR.getJSONObject(i);
        names.add((json_data.getString("name"))) ;
        grades.add((json_data.getString("grade"))) ;

    }



} catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}