public void preorder(Node temp)
{
    if(temp != null)
    {
        System.out.print(temp.data + " ");
        preorder(temp.left);
        preorder(temp.right);
    }
}