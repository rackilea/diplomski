private void siftUp(int k)
{
    E v = tree.get(k);
    while (k > 0 && v.compareTo(tree.get(k / 2)) == 1)
    {
        tree.add(k, tree.get(k / 2));
        k = k / 2;
    }
    tree.add(k, v);
}