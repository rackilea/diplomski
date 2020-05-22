int threadNumber = 0;

for (int i = 0; i <= 8; i++) {
    int thisThread = threadNumber;
    new Thread(() -> {
        System.out.println("Thread number : " +  thisThread);
    }).start();

    ++threadNumber; // Just i in this case.
}