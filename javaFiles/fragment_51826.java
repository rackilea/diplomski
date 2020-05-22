JsonArrayRequest jarr = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {

            try{

                for(int i=0;i<response.length();i++){
                    JSONObject job = response.getJSONObject(i);
                    String name = job.getString("name");

                }

            } catch (Exception e){


            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {


        }
    });

    requestQueue.add(jarr);