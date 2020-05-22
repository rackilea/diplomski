// allow only 10 outstanding objects to be in the work queue before it blocks
queue1 = new LinkedBlockingQueue<SourceObject>(10);
new Thread(new TargetDatabaseThread("url-to-database1", queue1)).start();
queue2 = new LinkedBlockingQueue<SourceObject>(10);
new Thread(new TargetDatabaseThread("url-to-database2", queue2)).start();
queue3 = new LinkedBlockingQueue<SourceObject>(10);
new Thread(new TargetDatabaseThread("url-to-database3", queue3)).start();
while (true) {
    SourceObject sourceObj = getFromSourceDatabase();
    // this might block if you set a capacity on your queue and it was full
    queue1.put(sourceObj);
    queue2.put(sourceObj);
    queue3.put(sourceObj);
}