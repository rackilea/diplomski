//queue is instance of CLQ
synchronized(queue) {
    if(!queue.isEmpty()) {
        ... queue.poll() //is not null
    }
}