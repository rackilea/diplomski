while (true) {
    String el = queue.poll();
    if (el == null)
        break; // no more elements
    Thread.sleep(20);
    System.out.println(el);
}