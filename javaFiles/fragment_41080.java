public class myFragment extends Fragment{
onCreate(){
     ...
     UpdateUI();
}

private void updateUI(){
    Factory factory = factory.get(getActivity());
    things = new ArrayList<>();
    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "10.0.2.2/...", null,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray arr = response.getJSONArray("user");
                    for (int i = 0; i < arr.length(); i++){
                        things.add(new Barang(arr.getJSONObject(i).getString("email"), i));
                        Log.d("GET", arr.getJSONObject(i).getString("email"));
                       //Update ListView or do something with the data
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        },
    ...
    );
    mRequestQ.add(request);
    ...
}