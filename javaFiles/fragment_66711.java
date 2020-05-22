StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            if (isJSONValid(response)) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray(uarray);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject p = array.getJSONObject(i);
                        Category_Movie item = new Category_Movie(
                                p.getInt("id"),
                                p.getString("mTitle"),
                                p.getString("mDesc"),
                                p.getInt("mYear"),
                                );
                        listItems.add(item);
                    }
                    mAdapter = new CategoryListAll_Adapter(listItems, getActivity());
                    recyclerView.setAdapter(mAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                // your Toast Message
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
        }
    });

    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
    requestQueue.add(stringRequest);