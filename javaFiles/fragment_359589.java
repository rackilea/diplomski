public synchronized E pop() {
        while (isEmpty()) {
            try {
                System.out.println("stack is empty cannot pop ");
                wait();
            } catch (InterruptedException e) {

            }
        }