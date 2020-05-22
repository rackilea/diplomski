JSONParser jsonParser = new JSONParser();
JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
JSONArray lang= (JSONArray) jsonObject.get("Hello");

List<Hello> objs = new ArrayList<Hello>();

for (int i = 0; i < lang.length(); i++) {
    JSONObject rec = lang.getJSONObject(i);
    String commentId = rec.getInt("CommentId");
    String comments = rec.getString("Comments");
    // ...

    Hello h = new Hello();
    h.setCommentId(commentId);
    h.setComments(comments);
    // ...

    // store you objects into list
    objs.add(h);
}