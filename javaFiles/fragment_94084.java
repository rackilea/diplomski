String postId = pageID + "_" + postID; // you should not generate it, take it from the feed
Connection<Comment> commentConnection = facebookClient.fetchConnection(postId + "/comments", Comment.class,
  Parameter.with("fields", "id,from{name,id}"));

for (List<Comment> commentList : commentConnection) {
  for (Comment comment : commentList) {
    System.out.println("Comment ID: " + comment.getId());
    System.out.println("User ID: " + comment.getFrom().getId());
    System.out.println("User Name: " + comment.getFrom().getName());
  }
}