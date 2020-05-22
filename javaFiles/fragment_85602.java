for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    title = jsonObject.getString(TITLE);
                    latLng = new LatLng(Double.parseDouble(jsonObject.getString(LAT)), Double.parseDouble(jsonObject.getString(LNG)));
                    coor = coor + jsonObject.getString(LAT) + "," + jsonObject.getString(LNG) +  "|";

                    // Menambah data marker untuk di tampilkan ke google map
                    addMarker(latLng, title);



}
tv2.setText(coor);