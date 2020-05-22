if (child.getKey().equals(key))
{
    return child;
}
else
{
    Node<K, V> res = getNode(key, child.getChildren());
    if (res != null) {
        return res;
    }
}