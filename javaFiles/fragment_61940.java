public class GetAddressPositionTask extends
        AsyncTask<String, Integer, LatLng> {

  GoogleMap googleMap;
  LatLng mapPosition;

  GetAddressPositionTask(GoogleMap map, LatLng position)
  {
   googleMap = map;
   mapPosition = position;
  }
    //...
@Override
    public void onPostExecute(LatLng result) {

     if(result != null)
     {
       Log.i("GEOCODE", result.toString());
       mapPosition =  result;

        googleMap.clear();
        googleMap.addMarker(new MarkerOptions()
                            .title("Shop")
                            .snippet("Is this the right location?")
                            .position(mapPosition))
                            .setDraggable(true);
      }
   }
}