public Node search(int val)
{
    Node target = null;
    if(this.getVal() == val)
    {
        return this;
    }
    else if(this.getRight() == null && this.getLeft() == null)
        return target;
    if(this.getRight() != null)
    {
        target = this.getRight().search(id);
    }
    if(target==null && this.getLeft() != null)
    {
        target = this.getLeft().search(id);
   }
   return target;