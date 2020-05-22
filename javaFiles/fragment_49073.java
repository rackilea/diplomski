void inorder(root_node)
{
    if(root_node != null)
    {
        inorder(root_node->left);
        println(root_node->value);
        inorder(root_node->right);
    }
}