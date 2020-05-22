JSONObject nodeStats = nodeRoot.getJSONObject("response");
 JSONArray jr = (JSONArray) nodeStats.getJSONArray("docs");
 for(int i=0;i<jr.length();i++)
 {
 JSONObject jb = jr.getJSONObject(i);
 String id = jb.getString("id");
 }