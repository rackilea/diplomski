public static void main(String[] args) {

    Thread inputThread = new Thread(new Runnable() {
        @Override
        public void run() {

            Scanner scan = new Scanner(System.in);
            String input = "";
            while (true) {
                System.out.println("Type something: ");
                input = scan.nextLine();
                System.out.println("Input: "+input);
            }
        }
    });

    inputThread.start();

    while (true) {

        System.out.println("");
        System.out.println("test");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}