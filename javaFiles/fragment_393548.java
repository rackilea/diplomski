/*************** PASS YOUR USERNAME AND PASSWORD TO FUNCTION *******************/
public void userValidationInfo(String username, String password){
String url = "url goes here"; // example.com/login.php 
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONArray dataArray;
                JSONObject jsonObject;
                String user_id,user_type,

                try {
                    jsonObject = new JSONObject(response);
                    dataArray = jsonObject.getJSONArray(JSON_ARRAY);

                        JSONObject obj;
                        try {
                            /***************** GET INFORMATION FROM REQUEST HERE ************************/
                            obj = dataArray.getJSONObject(0);
                            user_id = obj.getString(TAG_USER_ID);
                            user_type = obj.getString(TAG_USER_TYPE);


                            //Toast.makeText(getActivity(), brand_names, Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
               /***************** SET YOUR USER INFO HERE ****************/
                Log.e(TAG, "onResponse: "+response);


            }
        }, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        /****************** SHOW WAITING MESSAGE / ERROR MESSAGE HERE *****************/
        Toast.makeText(getContext(), "Taking bit longer ...", Toast.LENGTH_LONG).show();
    }

}){
/******************** POST YOUR PARAMETERS HERE *************************/
    @Override
    protected Map<String, String> getParams()
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        return params;
    }
};
queue1.add(stringRequest);
}