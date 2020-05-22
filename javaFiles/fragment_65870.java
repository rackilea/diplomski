public Node search(int val)
{
    Node target = this;
    if(target.getVal() == val)
        return this;
    else if(target.getRight() == null && target.getLeft() == null)
        return null;
    if(target.getRight() != null)
    {
        return target.getRight().search(id); //here lies the problem
    }
    if(target.getLeft() != null)
    {
        return target.getLeft().search(id);
   }
return null;