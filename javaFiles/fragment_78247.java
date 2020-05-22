@Override
protected void onPostExecute(String result) {

}


  View rootView = findViewById(android.R.id.content).getRootView();//This will return you the rootView



ClientSide cs = new ClientSide(getApplicationContext(),rootView);//do this in your mainactivity