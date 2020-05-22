if(root_node != null) {
        System.out.println(root_node.key);
    }

    if(root_node == null || root_node.key.equals(key)) {

        return root_node;
    }
    if(key.compareTo(root_node.key) > 0) {
        return searchRecursive(root_node.left, key);
    }

    return searchRecursive(root_node.right, key);