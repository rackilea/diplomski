class BadExampleFixed {
    private int counter;

    public synchronized void hit(){
        /*
         * Only one thread performs action (1), (2) at a time
         * "atomically", in the sense that other threads can not 
         * observe the intermediate state between (1) and (2).
         * Therefore, the counter will be accurate.
         */
        counter++;
    }
}