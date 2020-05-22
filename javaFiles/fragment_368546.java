public static void main(String...strings) throws JSONException {
        String s1 = "{\"a\":\"1\",\"b\":\"2\"}";
        String s2 = "{\"c\":\"4\",\"d\":[{}]}";

        int firstIndex = s2.indexOf("{");
        int lastIndex = s1.lastIndexOf("}");

        String result = s1.substring(0, lastIndex)+"," + s2.substring(firstIndex+1);        
        System.out.println(result);

        JSONObject jsonObject = new JSONObject(result);

        Iterator iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println("Key :: "+key+" value :: "+jsonObject.get(key));         
        }       
    }