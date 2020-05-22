Gson gson = new Gson();
Type typeOf = new TypeToken   <Map<String, String>>(){}.getType();
Map<String,String> map = gson.fromJson(jsonObject.toString(), typeOf);

 Set<String> keys = map.keySet();
    StringBuilder stringBuilder = new StringBuilder();
        for (String key : keys) {
         stringBuilder.append(key).append(",");
        }

String str = stringBuilder.toString();
str = str.replaceAll("get", "").replaceAll("set", "");

// also remove the duplicate
LinkedHashSet<String> list = new LinkedHashSet<String>(Arrays.asList(str.split(",")));
for (String property : list) {
    String lowerChar = Character.toString(property.charAt(0)).toLowerCase();
    System.out.println(lowerChar + property.substring(1, property.length()));
    }