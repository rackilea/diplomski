void ParseAPIWithJSON()
    {
     String readGooglePlace = readGooglePlaceAPI();
     try
     {

      InputStream is = new ByteArrayInputStream(readTwitterFeed.getBytes("UTF-8"));
      byte [] buffer = new byte[is.available()];
      while (is.read(buffer) != -1);
      String jsontext = new String(buffer);
      JSONObject entries = new JSONObject(jsontext);

      JSONArray hasil = entries.getJSONArray("results");
      results = hasil.getString(o);
      Log.i("TAG", results);
      int i;
      Log.i("TAG", Integer.toString(hasil.length()));
      numberofPlaces = hasil.length();
      for (i=0;i<hasil.length();i++)
      {
       JSONObject data = hasil.getJSONObject(i);
       namePlaces[i] = data.getString("name");
       Log.i("TAG", namePlaces[i]);
       JSONObject geometry = data.getJSONObject("geometry");
       JSONObject location = geometry.getJSONObject("location");
       latPlaces[i] = location.getDouble("lat");
       longPlaces[i] = location.getDouble("lng");
       Log.i("TAG", "Lat : "+latPlaces[i]+" Long : "+longPlaces[i]);
         }

     }
     catch (Exception je)
     {
      Log.e("TEST1", je.getMessage());
     }
    }