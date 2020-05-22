class ExtendsThread extends Thread {
    public void run() {
        while (!isInterrupted()) {
        }
        System.out.println("ExtendsThread " + isInterrupted());
    }
}