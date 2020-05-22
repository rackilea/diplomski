public static ArrayList<Long> getIds(ArrayList<Foo> tree, Long id_node) {
    ArrayList<Long> leaves = new ArrayList<Long>();
    for (Foo foo : tree) {
        if (foo.id_parent == id_node) {
            ArrayList<Long> ids = getIds(tree, foo.id);
            if (ids == null) {
                leaves.add(foo.id);
            } else {
                leaves.addAll(ids);
            }
        }
    }
    if (leaves.isEmpty()) {
        return null;
    }
    return leaves;
}