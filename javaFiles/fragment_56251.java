public void SetUpLikeAmount() {
     int likes = 0;
    // Set Up Database Source
    db.setUp("IT Innovation Project");
    String sql = "Select likeDislike_likes from forumLikeDislike WHERE topic_id = "
            + topicId + "";
    ResultSet resultSet = null;
    // Call readRequest to get the result
    resultSet = db.readRequest(sql);
    try {
        while (resultSet.next()) {
            likes += Integer.parseInt(resultSet.getString("likeDislike_likes"));
        }
        resultSet.close();
    } catch (Exception e) {
        System.out.println(e);
    }

    jLabel_like.setText(Integer.toString(likes));
}