JSONArray array = new JSONArray(yourJson);
for (int i = 0; i < array.length(); i++) {
    String courseSpec = array.get(i);
    String courseId = courseSpec.split(' ')[0]
    // and use your ID!
}