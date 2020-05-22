private List<Comment> treeQueue(Segment parent) {
    List<Comment> comments = new List<Comment>();
    Queue queue = new LinkedList();


    for (Comment comment : parent.getcomments()) {

        queue.add(comment);

        while(!queue.isEmpty()) {
            Comment node = (Comment)queue.remove();
            comments.add(comment);
            if (node.childCount > 0) {
                for (Comment child : ((Segment)node.getchildren()).getcomments()) {
                    queue.add(child);
                }
            }
        }
    }

    return comments;
}