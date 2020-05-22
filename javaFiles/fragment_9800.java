private void siftDown() {
        int k = 0;
        int l = 2*k+1;
        while (l < items.size()) {
            int min=l, r=l+1;
            if (r < items.size()) { // there is a right child
                if (comp.compare(items.get(r), items.get(l)) < 0) {
                    min = r;
                }
            }
            if (comp.compare(items.get(k), items.get(min)) > 0) {
                    // switch
                    E temp = items.get(k);
                    items.set(k, items.get(min));
                    items.set(min, temp);
                    k = min;
                    l = 2*k+1;
            } else {
                break;
            }
        }
    }