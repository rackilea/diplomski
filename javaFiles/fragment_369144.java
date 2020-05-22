try {
     JSONObject obj = new JSONObject(response);
            if (obj.has("Error")) {
                JSONObject objError = obj.getJSONObject("Error");
            } else if (obj.has("data")) {
                JSONObject objData = obj.getJSONObject("data");
            }
    } catch (Exception e) {
            e.printStackTrace();
    }