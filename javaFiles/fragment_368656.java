public void insert(E obj)
{
    tree.add(tree.size(), obj);
    siftUp(tree.size() - 1);
}

private void siftUp(int k)
{
    E v = tree.get(k);
    while (v.compareTo(tree.get(k / 2)) == 1)
    {
        tree.add(k, tree.get(k / 2));
        k = k / 2;
    }
    tree.add(k, v);
}