else
{
    System.out.println(path); //Not exactly sure what printing an ArrayList like this does, but you say it is doing what you want.
    printSum(path);
    printAllPathsFromRootToLeaf(tree.left(),new ArrayList(path));
    printAllPathsFromRootToLeaf(tree.right(),new ArrayList(path));
}