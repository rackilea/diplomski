public class ThreadReader {

    public static void main(String[] args) {
        File f = null;//folder
        final BlockingQueue<File> queue = new ArrayBlockingQueue<File>(1000);
        for(File kid : f.listFiles()){
            queue.add(kid);
        }

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for(int i = 1; i <= 5; i++){
            Runnable r = new Runnable(){
                public void run() {
                    File workFile = null;
                    while((workFile = queue.poll()) != null){
                        //work on the file.
                    }
                }
            };
            pool.execute(r);
        }
    }
}