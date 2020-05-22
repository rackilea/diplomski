JSONArray authors= volumeInfo.getJSONArray("authors");
String author = null;
if(authors.length() > 0) {
    author = authors.getString(authors.length() - 1);
} else {
    author="unknown";
}