// JSON String: [1, false, "false", "2"] rather than ["1", "false", "false", "2"]
String jsonEx = "[1,false,\"false\",\"2\"]";
// convert to JSONArray 
JSONArray array = new JSONArray(jsonEx);

// print out values and types
for (int i = 0; i < array.length(); i++) {
    Object o = array.get(i);
    System.out.printf("%-8s\t:%s\n", o,o.getClass());
}