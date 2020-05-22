private void rotateLeft(Entry<K, V> p) {
    if (p != null) {
        Entry<K, V> r = p.right;

        int delta = getWeight(r.left) - getWeight(p.right);
        p.right = r.left;
        p.updateWeight(delta);

        if (r.left != null) {
            r.left.parent = p;
        }

        r.parent = p.parent;


        if (p.parent == null) {
            root = r;
        } else if (p.parent.left == p) {
            delta = getWeight(r) - getWeight(p.parent.left);
            p.parent.left = r;
            p.parent.updateWeight(delta);
        } else {
            delta = getWeight(r) - getWeight(p.parent.right);
            p.parent.right = r;
            p.parent.updateWeight(delta);
        }

        delta = getWeight(p) - getWeight(r.left);
        r.left = p;
        r.updateWeight(delta);

        p.parent = r;
    }
  }