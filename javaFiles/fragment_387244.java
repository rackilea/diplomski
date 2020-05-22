Thread crawlerThread = new Thread(new FileCrawler(queue, new File("C:\\")));
Thread indexerThread = new Thread(new Indexer(queue));
crawlerThread.start();
indexerThread.start();
// 
// wait for them to finish.
crawlerThread.join();
indexerThread.join();