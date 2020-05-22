class Data{
  /* etc... */
  public String getText(){
    return this.title;
  }
}

Data data1 = new Data(1, "***", "title1", "snippet1",
                      0.0f, 0.0f, "http://www.something.something",
                      "tel:+00000000", 0,0);

Data data2 = new Data(1, "***", "title2", "snippet2",
                      0.0f, 0.0f, "http://www.something.something",
                      "tel:+00000000",
                      0,0);
/* etc... */

HashMap<String, Data> hashMap = new HashMap<String, Data>();
for(int i = 0; i < dataCount; i++) // add data instances in a loop. Define your own dataCount
  hashMap.add(data.getTitle(), data);

/* etc... */

myMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
  @Override
  public void onInfoWindowClick(Marker marker) {
    String titleOfClickedMarker = marker.getTitle();
    Data data = hashMap.get(titleOfClickedMarker);
    /* etc.. */
 }