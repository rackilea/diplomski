if(current!= null && current.left == null && current.right == null)//short circuit prevents dereferencing null pointer
{
    LeafNode leaf = (LeafNode) current;
    str += leaf.data;
    //no need to set current = root, we are leaving anyway
}