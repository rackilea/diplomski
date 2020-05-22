CustomObject poi = new CustomObject ();
if (jsonArray.getJSONObject(i).has("venue")) {
    poi.setName(jsonArray.getJSONObject(i).getJSONObject("venue").getString("name"));
    poi.setId(jsonArray.getJSONObject(i).getJSONObject("venue").getString("id"));
}
listTitle.addItem(poi);// Add to ListArray