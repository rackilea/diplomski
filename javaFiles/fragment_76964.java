JSONObject jsonObj = new JSONObject(response);
JSONArray gamesarray = jsonObj.getJSONArray("games");
JSONObject game0 = gamesarray.getJSONObject(0);
JSONArray fellowarray = game0.getJSONArray("fellowPlayers");
JSONObject fellow0 = fellowarray.getJSONObject(0);
Log.e("test", ""+fellow0.getInt("gameId"));