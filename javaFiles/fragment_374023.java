private void printOdd(int i) {
    synchronized (lock) {                        // <-------
        while (!oddTurn) {
            try {
                lock.wait();                     // <-------
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(type + i);
        oddTurn = false;
        lock.notifyAll();                        // <-------
    }
}