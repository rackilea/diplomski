private LinkedList<Integer> sharedList = new LinkedList<Integer>();
    private volatile int sharedValue = 0;
    private int MAX_LIMIT = 10;

    public void produce() throws InterruptedException {

        while (true) {

            if (sharedValue == MAX_LIMIT) { //'produce' thread waits if list is full
                synchronized (this) {
                    wait();
                }
            }
            synchronized (this) {
                sharedValue = sharedValue + 1;
                sharedList.add(sharedValue);
                System.out.println("added value: " + sharedValue);
            }

            if (sharedValue == 1) {
                synchronized (this) {
                    notify(); //notifies  'consume' thread if list is not empty
                }
            }
        }

    }

    public void consume() throws InterruptedException {

        while (true) {

            if (sharedValue == 0) {    //'consume' waits if list is empty
                synchronized (this) {
                    wait();
                }
            }

            synchronized (this) {
                sharedValue = sharedValue - 1;
                sharedList.remove();
                System.out.println("removed value: " + sharedValue);
            }

            if (sharedValue == MAX_LIMIT - 1) {
                synchronized (this) {
                    notify(); //notifies 'produce' if list is not full
                }
            }
        }

    }