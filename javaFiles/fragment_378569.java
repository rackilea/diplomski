/**
 * This method will completely wipe out (clear) all nodes 
 * from a JTree including the Root node. After using this 
 * method you will need to construct another tree model to 
 * refill it.
 * 
 * @param tree (JTree) The JTree Variable Name for which to 
 * wipe all nodes from.
 */
public static void wipeTree(JTree tree) {
    tree.setModel(null);
}