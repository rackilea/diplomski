// How to store JSON string
Gson gson = new Gson();
// This can be any object. Does not have to be an arraylist.
String json = gson.toJson(myAppsArr);

// How to retrieve your Java object back from the string
Gson gson = new Gson();
DataObject obj = gson.fromJson(arrayString, ArrayList.class);