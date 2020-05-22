public void gettingDerictions(double sourceLat, double sourceLong, double destLat, double destLong) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + sourceLat + "," + sourceLong + "&destination=" + destLat + "," + destLong + "&key=****************************";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       // Log.e("The response", response);
                       // List<LatLng> route = PolyUtil.decode(response);
                       // System.out.println(route);

                      List<LatLng> movements = new ArrayList<LatLng>();
                     try{
                      JSONObject json = new JSONObject(response);
                       //Retrieve routes from response
                      JSONObject jsonRoute = json.getJSONArray("routes").getJSONObject(0);
                       //Retrieve legs from routes 
                      JSONObject legs = jsonRoute.getJSONArray("legs").getJSONObject(0);
                       //Retrieve steps from legs
                      JSONArray steps = legs.getJSONArray("steps");
                      final int numSteps = steps.length();
                      JSONObject step;
                       //Retrieve points from steps
                      for (int i = 0; i < numSteps; i++) {
                       step = steps.getJSONObject(i);
                       String pontos = step.getJSONObject("polyline").getString("points");
                       movements.addAll(PolyUtil.decode(pontos));
                      }
                    }catch(Exception ex){
                      Log.d("DirectionErr",ex.getMessage());
                    }

                       //make use of movements object here
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("The response", "it didn't work");
            }
        });
        queue.add(stringRequest);

            }