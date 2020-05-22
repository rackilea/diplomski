while (true) {
    E element = queue.take();
    buffer.add(element);
    if (buffer.size() == 10) {
        doSomethingWithElements(buffer);
        buffer.clear();
    }
}