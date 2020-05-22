Polygon polygon;
 LatLng polLatLng;

PolygonOptions rectOptions=new PolygonOptions();

if(polarl.size()>0){
    for(int k=0;k<polarl.size();k++){
        String polLat =polarl.get(k).get("polLat").toString();
         String polLng =polarl.get(k).get("polLng").toString();
         if ( !polLat.trim().equals("") && !polLng.trim().equals("")){
             double HPollat = Double.parseDouble(polLat.trim());
             double HPolLong= Double.parseDouble(polLng.trim());
             polLatLng=new LatLng(HPollat, HPolLong);

             Log.e("POL LAT LANG", ""+polLatLng);

           rectOptions.add(polLatLng);

   }
    }
  }
   Polygon polygon1 = _googleMap.addPolygon(rectOptions.strokeColor(Color.RED).fillColor(Color.BLUE));