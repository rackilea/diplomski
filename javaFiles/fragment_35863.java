JSONArray arr1 = new JSONArray();
JSONArray arr2 = new JSONArray();

arr1.put(1);
arr1.put(2);
arr1.put(3);
arr1.put(4);
arr1.put(5);

arr2.put(2);
arr2.put(1);
arr2.put(3);
arr2.put(5);
arr2.put(4);

JSONObject o1 = arr1.toJSONObject(arr1);
JSONObject o2 = arr2.toJSONObject(arr2);

System.out.println(o1.equals(o2)); //true