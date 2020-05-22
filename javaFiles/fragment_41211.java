try {
        JSONObject myObject = new JSONObject();
        myObject.put("id", "00");
        myObject.put("action", "register");
        myObject.put("get_value", "true");
        JSONObject values = new JSONObject();
        values.put("user", "Jack");
        values.put("password", "Jhonson");
        values.put("id", "123456");
        myObject.put("values",values);
    } catch (JSONException e) {
        e.printStackTrace();
    }