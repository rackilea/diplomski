@Override
protected void onPostExecute(Void aVoid) {             
      MyArrayAdapter myArrayAdapter = new MyArrayAdapter(this, getData(),true);
      ListView l = (ListView) findViewById(R.id.listView);
      l.setAdapter(myArrayAdapter);   
}