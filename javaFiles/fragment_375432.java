try {
        JSONArray jsonArray = new JSONArray("<string result from API>");
        int lenght = jsonArray.length();
        String[] results = new String[lenght];
        for (int i = 0; i < lenght; i++) {
            results[i] = jsonArray.getJSONObject(i).getString("result");
        }
    }
    catch (JSONException ex){
        ex.printStackTrace();
    }