// Serialise
String[] array = {"One","Two","Three"};
String json = new Gson().toJson(array);

// De-serialise
String[] array = new Gson().fromJson(json,String[].class);