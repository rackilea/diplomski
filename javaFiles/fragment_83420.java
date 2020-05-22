public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Runnable myRunnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            };
            myRunnable.run();
        }
    }