public <T> T lookup(Node parent, String id, Class<T> clazz) {
    for (Node node : parent.lookupAll(id)) {
        if (node.getClass().isAssignableFrom(clazz)) {
            return (T)node;
        }
    }
    throw new IllegalArgumentException("Parent " + parent + " doesn't contain node with id " + id);
}