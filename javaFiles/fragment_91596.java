public static boolean treeLessThanTree(BinNode<Integer> t1, BinNode<Integer> t2) 
{
    if (t1 == null)
        return true;
    else if (t1.getRight() != null)
        return treeLessThanTree(t1.getRight(), t2);
    else 
        return lessThanTree(t2, t1.getValue());
}