public void retrieve() {

     JSONObject param = new JSONObject();

     try {
        param.put("sys_id", sys_Id);
     } catch (JSONException e) {
        e.printStackTrace();
     }

     // Pass the param while creating the request
     JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
            Constants.viewbranches_url, param,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("Branches");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject branch = jsonArray.getJSONObject(i);

                            int viewBranchID = branch.getInt(KEY_VB_ID);
                            String viewBranchUser = branch.getString(KEY_VB_USER);
                            String viewBranchPassword = branch.getString(KEY_VB_PASSWORD);
                            String viewBranchName = branch.getString(KEY_VB_NAME);
                            int viewBranchSYSID = branch.getInt(KEY_VB_SYSID);
                            int viewBranchCreated = branch.getInt(KEY_VB_CREATED);
                            String viewBranchUT = branch.getString(KEY_VB_UT);

                            testdata.append(
                                    String.valueOf(viewBranchID)+""+
                                            viewBranchUser+""+
                                            viewBranchPassword+""+
                                            viewBranchName+""+
                                            String.valueOf(viewBranchSYSID)+""+
                                            String.valueOf(viewBranchCreated)+""+
                                            viewBranchUT+"\n\n");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("response", "" + response);
                    }
                }

            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("response", "" + error);

        }
    }) {

        // Set the content type here
        @Override
        public String getBodyContentType() {
            return "application/x-www-form-urlencoded; charset=UTF-8";
        }

    };
    RequestHandler.getInstance(this).addToRequestQueue(jsonObjectRequest);
}