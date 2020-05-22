String jsonString = "[path: root / ClientDate, val1: 1521560221877,val2:1519818708657, comp: false],[path: root / ClientDate, val1: 1521560221877,val2:1519818708657, comp: false]";
    JSONObject mainObj = new JSONObject();
    JSONObject child = new JSONObject();
    JSONObject list;
    JSONObject objectId;

    try {
        String[] json1 = jsonString.split("(?=(,\\[))(,\\[)");
        for (String string : json1) {
            string = string.replaceAll("[\\[\\]]", "");
            String[] json = string.split(",");
            list = new JSONObject();
            for (int i = 0; i < json.length; i++) {
                String[] object = json[i].split(":");
                list.put(object[0], object[1]);
            }

            child.append("JSON", list);

        }
        objectId = new JSONObject();
        objectId.put("123456798", child);
        mainObj.put("SID", objectId);
        System.out.println(mainObj);
    } catch (JSONException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }