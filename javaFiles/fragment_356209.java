queue.add(root);
    while (!queue.isEmpty()) {
        if (stack.size()>0) {
            stack.push(null);
        }
        int sz = queue.size();
        for (int i=0; i<sz; ++i) {
            temp = queue.poll();
            stack.push(temp);
            // Enqueue first Right then left because we are storing the end result in stack which is actually LIFO
            if (temp.right != null) {
                queue.add(temp.right);
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
        }
    }