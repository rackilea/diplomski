ArrayList<String> array_list_values = new ArrayList<String>();
try {
       if (jObj.getInt("success") == 1) {

        Iterator iter = jObj.keys();
        while(iter.hasNext()){
        String key = (String)iter.next();
        String value = jObj.getString(key);
        array_list_values.add(value);
        }


        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, array_list_values));
                ListView listView = getListView();
            }
     }
catch (JSONException e) {
      Log.e(TAG, e.toString());
  }