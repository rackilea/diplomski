JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
            url, null, new Response.Listener<JSONObject>() {

        @Override
        public void onResponse(JSONObject response) {
            Log.d("REST", response.toString());

            try {
                JSONArray result = response.getJSONArray("result");
                Log.d("REST", result.toString());
                for (int i = 1; i <= result.length(); i++){

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }