@Override
    public Node clone() throws CloneNotSupportedException {
        Node cloned = new Node();

        cloned.elem = elem.clone();
        if (left != null) {
           cloned.left = left.clone();
           cloned.left.parent = cloned;
        }
        if (right != null) {
           cloned.right = right.clone();
           cloned.right.parent = cloned;
        }

        return cloned;
    }