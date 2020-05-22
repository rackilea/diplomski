private void loadJson()
{
    pd.setMessage("Mengambil Data");
    pd.setCancelable(false);
    pd.show();

    JsonArrayRequest reqData = new JsonArrayRequest(ServerAPI.URL_DATA,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    pd.cancel();
                    Log.d("volley","response : " + response.toString());
                    for(int i = 0 ; i < response.length(); i++)
                    {
                        try {
                            JSONObject data = response.getJSONObject(i);
                            ModelData md = new ModelData();
                            md.setNpm(data.getString("npm"));
                            md.setNama(data.getString("nama"));
                            md.setProdi(data.getString("prodi"));
                            md.setFakultas(data.getString("fakultas"));
                            mItems.add(md);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    pd.cancel();
                    Log.d("volley", "error : " + error.getMessage());
                }
            });

    AppController.getInstance().addToRequestQueue(reqData);
}