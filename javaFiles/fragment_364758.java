String strObject = "{\"Code\":\"a\", \"Name\": \"b\"}";
JSONArray myArray = new JSONArray();

for(int count = 0; count < 2; count++){
    JSONObject myObject = new JSONObject(strObject);

    myObject.put("Count", count);
    myArray.put(myObject);
}

System.out.println(myArray.toString());