private void loop() {
    synchronized (shared) {
        shared.v++;
        while(shared.v < N) {
            shared.wait();
        }

        shared.v = 0;
        synchronized (Q) {
            q.q = true;
        } 
    }