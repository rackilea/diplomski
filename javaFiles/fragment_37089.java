public static void main(String[] args) {

    Thread child = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("child doing its work");
        }
    });

    child.start(); // start child thread
    child.join(); // wait for child to finish

    System.out.println("Now back in main. Child has finished its work");
}