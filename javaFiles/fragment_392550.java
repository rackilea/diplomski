import java.lang.reflect.Constructor;

protected <T> List<T> castNodes(Class<T> clazz, List<Node>) {
    List<T> list = new ArrayList<T>();
    try {
        Constructor c = clazz.getConstructor(Node.class, getClass());        
        for (Node node : nodes)
            list.add((T) c.newInstance(node, this));
    } catch (Exception e) {
        // handle
    }
    return list;
}