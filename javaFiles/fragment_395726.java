Visit(Node node)
{
    foreach (Node childNode in node.Children)
    {
        Visit(childNode);
    }

    DoStuff(node);
}