HashMap<String, String> count = new HashMap<>();
        HashMap<String, String> previousCountDay = new HashMap<>();
        try {
            JSONObject mJsonObjectMain = new JSONObject("your json string");
            JSONObject mJsonObjectCount = mJsonObjectMain.getJSONObject("count");
            Iterator a = mJsonObjectCount.keys();
            while (a.hasNext()) {
                String key = (String) a.next();
                // loop to get the dynamic key
                String value = (String) mJsonObjectCount.get(key);
                System.out.print("key : " + key);
                System.out.println(" value :" + value);
                count.put(key, value);
            }

            JSONObject mJsonObjectPreviousCount = mJsonObjectMain.getJSONObject("previousCountDay");
            //do same as above
        } catch (JSONException e) {
            e.printStackTrace();
        }