public static void main(String[] args) {
    int retryCounter = 0;
    int maxRetries = 3;

    Thread t = new Thread(new Runnable() {
        public void run() {
            System.out.println("..." + Thread.currentThread());
            throw new RuntimeException("Thrown by me!!!");
        }});

    while (retryCounter < maxRetries) {
        try {
            Thread.sleep(3000);
            System.out.println("***" + Thread.currentThread());
            t.start();
            break;
        } catch (Exception e) {
            System.out.println("retrying attempt " + retryCounter);
            System.out.println(e);
            retryCounter++;
            if (retryCounter >= maxRetries) {
                throw new RuntimeException("Max retry exceeded");
            }
        } finally {
            System.out.println("in finally");
        }
    }
}