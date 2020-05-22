GetMemoryUsed(node)
{

    if(node is leaf)
        return (node.localMemory)

    return(GetMemoryUsed(node.left) + GetMemoryUsed(node.right) + node.localMemory);
}