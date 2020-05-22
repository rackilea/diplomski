/* Helper Methods */
// search a list of Nodes for a value
public static boolean listContainsNode(List<Node<Integer>> list, Integer data){
    for(Node<Integer> n : list)
        if(n.getData() == data)  // <-- Can you spot the bug?
            return true;
    return false;
}