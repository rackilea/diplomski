JsonObjectRequest myReq = new JsonObjectRequest(Request.Method.GET,
        "https://content.guardianapis.com/search?q=cancer%20new%20treatment&order-by=newest&api-key=test",
        null,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("Mpikeeeee");
                try {
                    JSONObject responseNode = response.getJSONObject("response");
                    JSONArray newsItems = responseNode.getJSONArray("results");

                    for (int i = 0; i < newsItems.length(); i++) {
                        JSONObject temp = newsItems.getJSONObject(i);

                        String title = temp.getString("webTitle");
                        newsFeed.add(new newsItem(title, "", "", "", "", 0));

                    }
                } catch (JSONException e) {
                    Log.i("myTag4", e.toString());
                }
            }

        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("myTag1", error.toString());
            }
        });