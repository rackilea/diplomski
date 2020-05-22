public class Mainactivity extends Activity{
ArrayList<String> ID = new ArrayList<String>();
ArrayList<String> TITLE= new ArrayList<String>();
ArrayList<String> CONTENT= new ArrayList<String>();
ArrayList<String> COUNT= new ArrayList<String>();

protected onCreate(Bundle savedInastanceState){


}

public void getData() {
         //your json code
      JSONArray contacts = jsonObject.getJSONArray("post");//(url);
          for(int i = 0; i < contacts.length(); i++){
              JSONObject c = contacts.getJSONObject(i);
              String id = c.getString("id");
              String title = c.getString("title");
              String  content = c.getString("content");
              String  count = c.getString("count");
             ID.add(id);
             TITLE.add(title);
             CONTENT.add(content);
             COUNT.add(count);
      }
  } catch (Exception e) {
      e.printStackTrace();
  }
    }


}
private class GetDataAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog Dialog = new ProgressDialog(MainActivity.this);

        protected void onPreExecute() {
            //
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Dialog.dismiss();
            //
        }

        @Override
        protected Void doInBackground(Void... params) {

            getData();
            return null;
        }
      @Override
      protected void onPostExecute(Void result) {

             for(int i=0; i<ID.size(); i++){
             mDbHelper=new GinfyDbAdapter(MainActivity.this);
              mDbHelper.open();
              mDbHelper.saveCategoryRecord(new Category(ID.get(i),TITLE.get(i),CONTENT.get(i),COUNTER.get(i)));
              }
    }