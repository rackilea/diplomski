JSONObject obj = (JSONObject)new JSONParser().parse(json);
JSONObject ele;
for(int i=0 ; (ele=(JSONObject)obj.get(Integer.toString(i)))!=null ; i++) {
    System.out.println("Index " + i + ":");
    System.out.println(ele.get("POI"));
    System.out.println(ele.get("latitude"));
    System.out.println(ele.get("longitude"));
    ///etc.
}