TreeTraverser<Tweet> traverser = new TreeTraverser<Tweet>() {
    @Override
    public Iterable<Tweet> children(Tweet root) {
        return root.replies;        }
};

List<Tweet> allTweets = new ArrayList<Tweet> (traverser.breadthFirstTraversal(root))