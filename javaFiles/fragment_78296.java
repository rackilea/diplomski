public void createThreads(int n){
    for (int i = 0; i < n; i++) {
        new Thread(() -> {
            for (int j = 1; j <= 100; j++) {
                System.out.println(j);
            }
        }).start(); // <-- .start() makes the thread start running   
    }
}