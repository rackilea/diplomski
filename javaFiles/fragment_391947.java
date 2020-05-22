public static List<Beacon> fromJson(JSONArray array)
{
  ArrayList<Beacon> res = new ArrayList<>();
  for (int i = 0; i < array.length(); ++i)
  {
    JSONObject beacon = array.getJSONObject(i);
    res.add(new Beacon(beacon.getInt("beaconId"), beacon.getString("name"), beacon.getString("imageUrl"))));
  }

  return res;
}