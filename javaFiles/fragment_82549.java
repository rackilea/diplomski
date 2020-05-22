class Node {
    public T asNode(Class<T extends Node> clazz) {
        return clazz.cast(this);
    }
}

class NodeWrapper<N extends Node> {
    private N realNode;
    public T asNode(Class<T extends Node> clazz) {
        try {
            return super.asNode(clazz);
        }
        catch (ClassCastException e) {
            return realNode.asNode(clazz);
        }
    }
}