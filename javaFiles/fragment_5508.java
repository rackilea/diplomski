JSONObject jsonObject = new JSONObject(response);
    String name = jsonObject.getString("status");
    String name1 = name.trim();
    if (name1.equals("success")) {

        Toast.makeText(getApplicationContext(), "inside", Toast.LENGTH_LONG).show();
        try {


            JSONObject jsonObjectData = jsonObject.getJSONObject("data");
            s_key = data.getString("initKey");
            s_iv = data.getString("initIv");
            sec_url = data.getString("url");
            s_init_hash = data.getString("initHash");


        } catch (JSONException e) {
            e.printStackTrace();


        }


    }