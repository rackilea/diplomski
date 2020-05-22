package foo;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ReadThenAll {

    // subfolders to explore
    private final Queue exploreList = new ConcurrentLinkedQueue();

    private long counter = 0;

    public void count() {
        counter++;
    }

    public static void main(String[] args) {

        ReadThenAll me = new ReadThenAll(5);
        me.scan("/tmp");

    }

    int[] threads;

    public ReadThenAll(int numberOfThreads) {
        threads = new int[numberOfThreads];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = -1;
        }
    }

    void scan(String fileName) {

        final long start = System.currentTimeMillis();

        // add the first one to the list
        File file = new File(fileName);
        exploreList.add(file);

        for (int i = 0; i < threads.length; i++) {
            FileExplorer explorer = new FileExplorer(i, this);
            Thread t = new Thread(explorer);
            t.start();
        }

        Thread waitToFinish = new Thread(new Runnable() {

            @Override
            public void run() {

                boolean working = true;
                while (working) {
                    working = false;

                    for (int i = 0; i < threads.length; i++) {
                        if (threads[i] == -1) {
                            working = true;
                            break;
                        }
                    }

                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                long elapsed = System.currentTimeMillis() - start;
                System.out.println("total time (ms) : " + elapsed);

            }
        });

        waitToFinish.start();
    }

    public void done(int id, int counter) {
        threads[id] = counter;
    }

    class FileExplorer implements Runnable {

        public int counter = 0;
        public ReadThenAll owner;
        private int id;

        public FileExplorer(int id, ReadThenAll owner) {
            this.id = id;
            this.owner = owner;
        }

        @Override
        public void run() {
            while (!owner.exploreList.isEmpty()) {

                // get the first from the list
                try {
                    File file = (File) owner.exploreList.remove();

                    if (file.exists()) {

                        if (!file.isDirectory()) {
                            doThemagic(file);
                        } else {

                            // add the files to the queue
                            File[] arr = file.listFiles();
                            if (arr != null) {
                                for (int i = 0; i < arr.length; i++) {
                                    owner.exploreList.add(arr[i]);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // silent kill :)
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            owner.done(id, counter);
            System.out.println("total of files : " + counter);
        }

        private void doThemagic(File file) {
            System.out.println(file.toString());
            counter++;
        }
    }

}