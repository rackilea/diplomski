FileOutputStream toFile = // Open the stream to a file
SomeDBClass db = // Set up the db connection
PipedInputStream pi = new PipedInputStream(); // Optionally specify a size
PipedOutputStream po = new PipedOutputStream( pi );

ExecutorService exec = Executors.newFixedThreadPool(2);
exec.submit( new Producer( po, db ) );
exec.submit( new Consumer( pi, toFile ) );
exec.shutdown();