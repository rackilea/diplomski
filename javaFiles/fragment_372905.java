public void deleteNode(treeNode focusNode, int data)
{
 if(data<focusNode.data)
    deleteNode(focusNode.left,data);
else if (data>focusNode.data)
    deleteNode(focusNode.right,data);
else
{
    treeNode parent = focusNode.getParent();  // get the parent.
if(focusNode.left==null && focusNode.right==null) 
    {
        if(parent.left.equals(focusNode))
             parent.left = null;                //Set the parents reference to null. 
        else
             parent.Right = null;
    }
 else if(focusNode.left!=null && focusNode.right==null)
    {
        if(parent.left.equals(focusNode))
             parent.left = focusNode.left;  //Reassign the parents reference to the correct node. 
        else
             parent.right = focusNode.left;
    }