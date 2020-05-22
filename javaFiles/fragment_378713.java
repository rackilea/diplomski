class X implements Runnable {
    public void run() {
        System.out.println("This is running on a different thread!");
    }

    public static void main(String[] arg) {
        new Thread(new X()).start();
    }
}