private void prepareFriendsList() {
    requestQueue = Volley.newRequestQueue(this);
    StringRequest request=new StringRequest(Request.Method.POST,
            "http://192.168.0.103/PlaneEye/v1/allFriend",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        List<User> users = new ArrayList<>();
                        JSONObject user = new JSONObject(response);


                        JSONArray friends=user.getJSONArray("users");
                        for (int i = 0; i <friends.length() ; i++) {
                            final JSONObject friend = friends.getJSONObject(i);
                            friend_id      = friend.getInt("user_id");
                            friend_Fname = friend.getString("fName");
                            friend_Lname = friend.getString("lName");

                            latitude    = friend.getDouble("latitude");
                            longitude   = friend.getDouble("longitude");
                            int online = friend.getInt("online");
                            users.add(new User(friend_id,friend_Fname,friend_Lname,latitude,longitude,online));
                            //setUserInf(userInf); // Dont update the entire list every iteration.
                        }
                        Log.d("Users parsed, call back to set Users!");
                        setUserInf(users);

                    } catch (JSONException e) {

                    }
                }
            }, 
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("userData", "Error");
            }
    });
    requestQueue.add(request);
    Log.d("Request Sent!");
    //return getUserInf(); // empty list since users not parsed yet 
}