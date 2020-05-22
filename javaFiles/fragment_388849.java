public static int largestSSN(Node<Integer, Person> rootNode, int highestSSN) {
if(rootNode != null) {
//I think following 2 lines are useless, since BST already has rightNode.info.SSN greater than rootNode.SSN
    if (rootNode.info.SSN > highestSSN)
        highestSSN = rootNode.info.SSN;
    highestSSN=largestSSN(rootNode.rightChild, highestSSN);//***CHANGED
}
return highestSSN;
}