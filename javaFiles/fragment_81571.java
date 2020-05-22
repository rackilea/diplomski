private  List<String> list = new ArrayList<>(); 
    private void setupList() {

        ListView listView = (ListView) findViewById(R.id.list_view);
        adapter = new ListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private void createList() {


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject obj = jsonArray.getJSONObject(i);
                        String areaName = obj.getString("area_name");
                        list.add(areaName);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        GetAreaListRequest registerRequest = new GetAreaListRequest("True", responseListener);
        RequestQueue queue = Volley.newRequestQueue(AreaListActivity.this);
        queue.add(registerRequest);


    }