public static void main(String args[]) {
    int period = 2000;
    int delay = 2000;

    Timer timer = new Timer();

    timer.scheduleAtFixedRate(new TimerTask() {
        // Variables as member variables instead of local variables in main()
        private double lastPrice = 0;
        private Price priceObject = new Price();
        private double price = 0;

        public void run() {
            price = priceObject.getNextPrice(lastPrice);
            System.out.println();
            lastPrice = price;
        }
    }, delay, period);      
}