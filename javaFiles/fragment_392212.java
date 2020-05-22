Iterator<JSONObject> iterator = userArray.iterator();
        while (iterator.hasNext()) {
             JSONObject factObj = (JSONObject) iterator.next();
             String userName = (String) factObj.get("Username");
             String passWord = (String) factObj.get("Password");
        }