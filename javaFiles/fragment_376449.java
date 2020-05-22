private Node delete(Node root, String data)
{
    //in case list is empty then return
    if(root==null) return n;
    //in case node to be deleted is root then just return next as new root
    if (root.name.equals(data)) return root.in;

    Node curr = root;
    while(curr.in!=null)
    {
        if (curr.in.name.equals(data))
        {
            //curr.in's referenced Node will be garbage collected (or run some cleanup manually on it)
            curr.in = curr.in.in;
            //we are done and root is same
            return root;
        }
        curr = curr.in;
    }
    //if here then not found and nothing changed
    return root;
}