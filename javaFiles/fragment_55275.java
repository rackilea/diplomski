/**
 * Checks whether a node with the given key exists in the tree
 * @param haystack    Tree to find the key in
 * @param nodeKey     Node key to be found
 * @return True if the node was found (determined by getting the top location), false if the node was not found
 */
private boolean nodeExists(SapTree haystack, String nodeKey)
{
    try
    {
        haystack.getNodeTop(nodeKey);
        return true;
    } catch (RuntimeException rex)
    {
        return false;
    }
}