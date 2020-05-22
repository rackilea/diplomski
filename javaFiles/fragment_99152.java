JSONObject params = new JSONObject();
        try {
            params.put("method", method);
            params.put("format", format);
            params.put("name", username);
            params.put("buildingname", userbuildingname);
            params.put("area", userarea);
            params.put("city", usercity);
            params.put("mobileno", usermobileno);
            params.put("email", useremail);
            params.put("confirmpassword", userconfirmpassword);
        } catch (Exception e) {

        }
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, URL, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.v("Response:%n %s", response.toString());
                        SignUp signUp = new SignUp();
                        try {
                            returnResponse(response.getString("saveUsersDetailsResponse"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        }
        );
        AppController.getInstance().addToRequestQueue(req);