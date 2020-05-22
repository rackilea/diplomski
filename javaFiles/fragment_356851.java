Gson gson = new Gson();

int[] sub = { 0, 59, 16 };
Object[] values = { 0, 43.0, sub };
String output = gson.toJson(values);       // => [0, 43.0,[0,59,16]]

Object[] deserialized = gson.fromJson(output, Object[].class);
for ( Object obj : deserialized ) {
    // => 0.0, 43.0, [0.0, 59.0, 16.0]
}