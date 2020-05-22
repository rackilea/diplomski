private synchronized Integer consume() {
    try {
        while (_list.isEmpty()) 
            wait();
        return _list.poll();
    } catch(InterruptedException e) {
        throw new IllegalStateException("Interrupted");
    }
}