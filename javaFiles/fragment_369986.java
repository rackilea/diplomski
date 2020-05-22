JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("invite",1);
            String a=jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }