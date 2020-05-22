private class LongOperation extends AsyncTask<String, Void, JSONObject> {

      @Override
      protected JSONObject doInBackground(String... params) {
          // Hashmap for ListView
          ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();
          try {
             // Creating JSON Parser instance
             JSONParser jParser = new JSONParser();

             // getting JSON string from URL
             JSONObject json = jParser.getJSONFromUrl(url);
          } catch(Exception ex) { // many diffent exceptions better handle seperatelly
              Log.e("error", "error", ex);
              return null;
          }

            return json;
      }      

      @Override
      protected void onPostExecute(JSONObject result) {

            // do smth with the result
            String str = (json == null)?"json = null":json.toString(4);
            tvHello.setText(str);
      }

}