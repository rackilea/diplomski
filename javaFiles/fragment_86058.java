public deleteEntry(String entry) {
    if (map.containsKey(entry)) {
        Comment comment = map.get(entry);
        map.remove(entry);
        if (comment.getChildren() != null) {
            for(int i = 0; i < comment.getChildren().size(); i++) {
                deleteEntry(comment.getChildren().get(i));
            }
        }
    }
}