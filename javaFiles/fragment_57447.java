for(int i=0;i<json.length();i++)
{
    String lat=json.getJSONObject(i).get("lat").toString();
    String lon=json.getJSONObject(i).get("lon").toString();
    lats[i]=lat;
    lons[i]=lon;

    System.out.println(lats[i]+","+lons[i]);
}

request.setAttribute("lats", lats);
request.setAttribute("lons", lons);