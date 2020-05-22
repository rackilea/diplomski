@Override
public void onResponse(String response) {
    try{
        JSONObject object= new JSONObject(response);
        JSONArray mealsArray = object.getJSONArray("result");
        for(int i=0;i<mealsArray.length();i++){
            JSONObject cur = mealsArray.getJSONObject(i);
            int id= cur.getInt("id");
            String name= cur.getString("name");
            String description = cur.getString("description");
            int price = cur.getInt("price");
            meals.add(new meal(id,name,price,description));
        }
        Log.i("debug","meals size = "+meals.size());
        updateData();
    }
    catch(JSONException e){
        e.printStackTrace();
    }
}