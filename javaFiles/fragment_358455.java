// creating json array
        JSONArray numberArray = new JSONArray();
        numberArray.put(0, tn);

        // send the array with payload
        JSONObject json = new JSONObject();
        json.put("env", "DEV");
        json.put("destNumbers", numberArray);