while (running) {
    while (queue.peek() != null) {
        // logging
        List<Float> list = queue.poll();
        if (list == null) {
            continue;
        }
        // do stuff with list
    }
}