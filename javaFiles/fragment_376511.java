public static void main(String args[]) {

     new Thread(new ThreadTask(new File("D:/test1.log")),"thread1").start();
     new Thread(new ThreadTask(new File("D:/test2.log")),"thread2").start();
}

private static class ThreadTask implements Runnable {
    private File logFilePath;        

    // you should inject the file path of the log file to watch
    public ThreadTask(File logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void run() {
        // read file
    }
}