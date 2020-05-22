public List<Integer> sortIt(Node node) {
        return SortTree(node, new ArrayList<>());
    }

    private List<Integer> SortTree(Node node, List<Integer> result) {

        if (node.getLeft() != null) {
            SortTree(node.getLeft(), result);
        }

        result.add(node.getValue());

        if (node.getRight() != null) {
            SortTree(node.getRight(), result);
        }

        return result;
    }