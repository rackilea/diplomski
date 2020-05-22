ArrayList<String> array_list_values = new ArrayList<String>();
try {
       if (jObj.getInt("success") == 1) {

        array_list_values.add(jObj.getString("0"));
        array_list_values.add(jObj.getString("1"));
        array_list_values.add(jObj.getString("2"));
        array_list_values.add(jObj.getString("3"));
        array_list_values.add(jObj.getString("4"));
        array_list_values.add(jObj.getString("5"));
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, array_list_values));
                ListView listView = getListView();
            }
     }
catch (JSONException e) {
      Log.e(TAG, e.toString());
  }