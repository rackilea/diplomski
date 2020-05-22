for(long next = System.currentTimeMillis() + 100;; start += 100) {
    // do something
    while(true){
        long delay = next - System.currentTimeMillis();
        if (delay <= 0)
            break;
        Thread.sleep(delay);
    }
}