public ClassicView getClassicViewWithId(int id,Context context) 
                                                throws JSONException {

     classicSetLabel(myView.getJSONObject(i).getJSONArray("Label"),
                                                myClassicView,context);
        return null;
  }

 public void classicSetLabel(JSONArray myArrayLabel, ClassicView classicView,
                                      Context context) throws JSONException {

        for (int i = 0; i < myArrayLabel.length(); i++) {
            Log.e("CLASSICVIEW", classicView.toString());
            TextView myTextView = new TextView(context);

        }
}