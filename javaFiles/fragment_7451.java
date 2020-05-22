public void produce() {
    int i = 0;
    while (i < 100) {
        synchronized(Q) {
            if (Q.size() < max_capacity) {
                Q.add(i);
                System.out.println("Produced Item" + i);
                i++;
                Q.notify();
            } else {
                try {
                    Q.wait();
                } catch (InterruptedException e) {
                    System.out.println("Exception");
                }
            }
        }
    }
}