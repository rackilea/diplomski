public static void main(String[] args) {

    System.out.println("START");

    CancelableReader reader = new CancelableReader(new InputStreamReader(System.in));
    String line;

    new Thread(() -> {

        try {

            Thread.sleep(10000);
            reader.cancelRead();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }).start();

    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }

    System.out.println("END");

}