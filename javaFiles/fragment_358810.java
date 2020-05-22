private Map<Comment, List<Comment>> replies = new HashMap<Comment, List<Comment>>();

public List<Comment> handleReplies(Comment comment){
    if (!replies.containsKey(comment)) {
        replies.put(comment, myEJB.getRepliesFromComment(comment));
    }

    return replies.get(comment);
}