@Override
protected void onPostExecute(ArrayList<Information> s) {
    super.onPostExecute(s);
    // Dismiss the progress dialog
    //listAdapter=new CustomAdapter(Screen2.this,record_list);
    record_list = s;
    listAdapter=new CustomAdapter(Screen2.this,record_list);
    list_view.setAdapter(listAdapter);
    if (pDialog.isShowing())
        pDialog.dismiss();

    /**
     * Updating parsed JSON data into ListView
     * */
}