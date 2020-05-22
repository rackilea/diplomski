public static int countRed(Node node) {
    int nbRed = 0;
    if (node == null) {
        return 0;
    }
    nbRed += countRed(node.left);
    nbRed += countRed(node.right);

    if(node.isRed()){
        nbRed++;
    }
    return nbRed;
}