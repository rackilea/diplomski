StringRequest get = new StringRequest(Method.POST, URL, new Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray myArray = new JSONArray(response);

                    for(int i = 0; i < myArray.length(); i++)
                    {
                        JSONObject jObj = myArray.getJSONObject(i);
                        // get your data here

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }