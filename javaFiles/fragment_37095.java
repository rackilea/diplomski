private static JSONObject processString(List<String> list, int level,String key) throws JSONException {
        JSONObject json = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        String  value = "";
        String remainder = "";
        JSONObject obj = new JSONObject();
        for(String data : list)
        {
            String name = data;
            int index = data.indexOf(',');

            name = data.substring(0, index);
            remainder = data.substring(name.length() + 1);

            String fullpath = key+"***"+name;

            value = fullpath;
            System.out.println(fullpath);


            json.put("name", fullpath);

            remainder = data.substring(index+1);
            int lastindex = remainder.indexOf('(');
            if (lastindex > 0) {
                remainder = remainder.substring(0,lastindex);
            }
            String fullpathVal = key+"***"+remainder;

            obj.put("name", fullpathVal);
            jsonarray.put(obj);
            json.put("T" + level, jsonarray);
        }
        return json;
    }