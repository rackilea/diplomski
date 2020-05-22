jsonResponse = new JSONArray(response);
 //data.clear();
 for (int i = 0; i < jsonResponse.length(); i++) {
     Object obj = jsonResponse.get(i);
     if(obj instanceof JSONObject) {
          HashMap<String, String> m = new HashMap<>();
          JSONObject object = jsonResponse.getJSONObject(i);
          m.put(object.getString("id"), object.getString("name"));
          dataPlants.add(m);
     }
 }
 //sAdapter.notifyDataSetChanged();