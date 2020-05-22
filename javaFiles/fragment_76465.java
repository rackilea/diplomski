public static String[] huffman(int[] histo){
        //build up initial list of nodes
        List<Node> tree = new ArrayList<>();
        for (int i = 0; i < histo.length; i++)
            if(histo[i] != 0)
                tree.add(new Node(histo[i], i));

        //combine lowest weights untill only the root is left
        while(tree.size() > 1){
            combine(tree);
        }

        //recursively generate code for each node in the tree
        //if the recursion finds a leaf node,
        //it sets the correct element in the array to the code of the node
        Node root = tree.get(0);
        String[] codage = new String[histo.length];
        root.generateCodes(codage);

        return codage;
    }

    /**
     * Sorts the list and combines the first two nodes in the list to a single node.
     */
    private static void combine(List<Node> list){

        if(list.size() < 2)
            return;

        Collections.sort(list);

        Node smallest = list.remove(0);
        Node secondToSmallest = list.remove(0);

        Node parent = new Node(secondToSmallest, smallest, smallest.getValue()+secondToSmallest.getValue());

        list.add(0, parent);
    }