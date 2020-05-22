private void parseJson(String responseString){
        try {

            Object object = new JSONTokener(responseString).nextValue();
            if (object instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) object;
                JSONArray jsonArray = jsonObject.getJSONArray("items");

                for (int i = 0; i < jsonArray.length(); i++) {
                    Object object1  = jsonArray.getJSONObject(i);
                    if (object1 instanceof JSONObject) {
                        JSONObject jsonObject1 = (JSONObject) object1;
                        JSONObject jsonObject2= jsonObject1.optJSONObject("id");
                        String videoId = jsonObject2.optString("videoId");
                        System.out.println("videoId=" + videoId);
                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }