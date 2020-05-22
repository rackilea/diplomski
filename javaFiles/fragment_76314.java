private static final Type REVIEW_TYPE = new TypeToken<List<Review>>() {
}.getType();
Gson gson = new Gson();
JsonReader reader = new JsonReader(new FileReader(filename));
List<Review> data = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
data.toScreen(); // prints to screen some values