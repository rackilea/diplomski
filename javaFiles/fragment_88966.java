Queue<File> q = ...
    File c;
    while ((c = q.poll()) != null) {
        if (c.isDirectory()) {
            for (cc : c.listFiles()) {
                q.offer(cc);
            }
        } else {
            children.add(c);
        }
    }