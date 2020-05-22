private void addMarkersToMapNew()
{
    //TODO addMarkersToMapNew
    int markerCount = 0;
    //ProgressDialog progDailog = null;

    if (ConnectionEcardMessage.isConnectingToInternet(SearchMapFragmentActivity.this))
    {
        ArrayList<MapConstants> _list = new ArrayList<MapConstants>();
        _list.addAll(GlobalVariablesClass.FOR_MAPMARKER);
        Log.i("addMarkersToMapNew-size", ""+_list.size());

        Log.i("addMarkersToMapNew", "ConnectionEcardMessage.isConnectingToInternet(SearchMapFragmentActivity.this)");
        if (mMapMarkers == null)
        {
            Log.i("addMarkersToMapNew", "null");
           mMapMarkers = new HashMap<String, MarkerOptions>();
           extraMarkerInfo = new ArrayList<HashMap<String, String>>();

            EcardMessage.appendLog("SearchMapFrag 6.5 - get curBranchDetails");


            for (int i = 0; i < _list.size(); i++)
            {
                HashMap<String, String> contactHashmap = new HashMap<String, String>();
            Log.d("myApp", "added branch " + _list.get(i).getClinicName());

            MarkerOptions markerOption = (new MarkerOptions()
                        .position(  
                            new LatLng(Double.valueOf(_list.get(i).getLatitude()), 
                                       Double.valueOf(_list.get(i).getLongitude()))) 
                  .title(_list.get(i).getClinicName())                       .snippet(_list.get(i).getUnitNo()+""+_list.get(i).getBldgName()+","+_list.get(i).getStreet()+", "+_list.get(i).getCountry())
                  .icon(BitmapDescriptorFactory.fromResource(R.drawable.address)));


                Log.i("Latitude_At_Longitude", "EDI WOW");

               contactHashmap.put("landline", _list.get(i).getLandline() );
               Log.i("kay landline", _list.get(i).getLandline());
               contactHashmap.put("mobile", _list.get(i).getMobile() );
               Log.i("kay Mobile", _list.get(i).getMobile());
               contactHashmap.put("fax", _list.get(i).getFax() );
               Log.i("kay Fax", _list.get(i).getFax());
               contactHashmap.put("title", _list.get(i).getClinicName());
               Log.i("kay title", _list.get(i).getClinicName());
               extraMarkerInfo.add(contactHashmap);

                mMapMarkers.put("Marker" + ++markerCount, markerOption);
                mMap.addMarker(markerOption);


            }

        }
}