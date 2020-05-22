public AlbumNode getAlbum(AlbumNode node, String name) {
    if (node == null) {     // this checks the base case
        return null;        // your original code failed for a null root
    } else {
        if (node.getName().equals(name)) {
            return node;
        } else {
            AlbumNode result = getAlbum(node.left, name);
            if (result != null) {
                return result;
            }
            result = getAlbum(node.right, name);

            return result;  // you need to return the result inside the recursion
        }                   // your original code never returned the recursive calls
    }
}