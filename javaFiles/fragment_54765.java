HashMap<String, String> params = new HashMap<String, String>();
params.put("lat", ""+lat);
params.put("lon", ""+lon);
params.put("name", name);

JsonObjectRequest strReq = new JsonObjectRequest(
          AppConfig.URL_GPS, new JSONObject(params), new Response.Listener<String>() {