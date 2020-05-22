@Override
protected Void doInBackground(Map... data) {
    // TODO Auto-generated method stub
    Log.i("TEST", "NEW THREAD FIRING !!!");
    Map myMap = data[0];
    Log.d("DATA", myMap.get("name"));

    return null;
}