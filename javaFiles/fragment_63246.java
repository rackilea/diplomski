try {
    JSONArray jsonArray = new JSONArray(JSON);
    int length = jsonArray.length();
    int i = 0;
    System.out.println("itxcc = " + length);
    for (int i=0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            System.out.println("itxcc = " + obj.getString("name"));
        }
    }
    catch (Exception ex) {
        ex.printStackTrace();
    }