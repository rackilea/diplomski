public String treeLevelOrder(Node root) {
        StringBuilder result = new StringBuilder("");
        Queue<Node> current = new LinkedList<>();
        Queue<Node> other = new LinkedList<>();
        if(root != null)
            current.add(root);

        while(!current.isEmpty()) {
            while(!current.isEmpty()) {
                Node node = current.remove();
                result.append(",");
                result.append(node.datum);

                // adding children to the other queue
                if(node.left != null)
                    other.add(node.left);
                if(node.right != null)
                    other.add(node.right);
            }

            // swapping the queues
            Queue<Node> temp = current;
            current = other;
            other = temp;
        }

        // building final string
        if(result.length() == 0)
            result.append("[");
        else
            result.setCharAt(0,'[');
        result.append("]");
        return result.toString();
    }