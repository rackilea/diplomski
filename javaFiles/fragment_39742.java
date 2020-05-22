public void myFunction() {
    boolean successful = false;
    int retryCount = 0;
    while(retryCount < 5 && !successful) {
        try {
            for (int i = 0; i <= 15; i++) {
                System.out.println("Counting: " + i);
            }
            successful = true;
        } catch (Exception e) {
            e.printStackTrace();
            successful = false;
            retryCount++;
        }
    }
}