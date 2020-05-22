try
    {
        JSONObject jsonObject = new JSONObject("{" +"\"server_response\": [{" +"\"Total\": \"135\"," +"\"Paid\": \"105\"," +"\"Rest\": \"30\"" +"}]"+"}";);
        JSONArray jsonArray = jsonObject.getJSONArray("server_response");
        JSONObject object = jsonArray.getJSONObject(0);

        for (String key : iterate(object.keys())) 
        {
            // here key will be containing your OBJECT NAME YOU CAN SET IT IN TEXTVIEW.
            Toast.makeText(HomeActivity.this, ""+key, Toast.LENGTH_SHORT).show();
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }