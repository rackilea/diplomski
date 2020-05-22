public JSONArray getJSON(File inputFile) throws IOException, JSONException {
    String content = FileUtils.readFileToString(inputFile);
    content = content.substring(4, content.length() - 1);
    JSONArray jsonArray = new JSONArray("[" + content + "]");
    return jsonArray;
}