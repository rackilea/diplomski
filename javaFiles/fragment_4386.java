@Override
protected void onCreate(Bundle savedInstanceState) {
  ....
  ....

  button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       newsSettings = new NewsSettings();
       newsSettings.setPreferredCity(pref.getString("prefCity", ""));

       /** here is the modification **/
       getData(newsSettings);
  }

}