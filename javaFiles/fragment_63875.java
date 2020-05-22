private static void createTree(ArrayList<String> result, Node tree) {
    if (result != null && !resultat.isEmpty()) {
        Node child = new Node(result.get(0));
        tree.addChild(child);

        createTree(result.subList(1, result.size()), child);  
    }