private Void printPreorder(AVLNode<AnyType> t) 
{   
    if (t != null)
    {
        System.out.print(t.element + " ");
        printPreorder(t.left);
        printPreorder(t.right);
    }
}

public Void print() 
{
        printPreorder(root);
}