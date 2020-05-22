JSONArray authorArray = volumeInfo.getJSONArray("authors");
String authorBook = "";
for (int i = 0; i < authorArray.length(); i++) {
    // Add a comma after each author unless it is the last one.
    String author = authorArray.getString(i);
    if (i == authorArray.length() - 1) {
       authorBook = authorBook + author;
    } else {
       authorBook = authorBook + author + ", ";
    }
}