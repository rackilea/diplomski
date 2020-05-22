public Node<T> buildTree(String expression)
{
    T[] expressionSplit = (T[]) expression.split("\\s{1,}");
    for (int i = 0; i < expressionSplit.length; i++)
    {
        insert(expressionSplit[i]);
    }
    return root;
}