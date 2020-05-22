class Producer implements Runnable {

    private final OutputStream out;
    private final SomeDBClass db;

    public Producer( OutputStream out, SomeDBClass db ){
        this.out = out;
        this.db = db;
    }

    public void run(){
        // If you're writing to a text file you might want to wrap
        // out in a Writer instead of using `write` directly.
        while( db has more data ){
            out.write( the data );
        }
        out.flush();
        out.close();
    }
}

class Consumer implements Runnable {

    private final InputStream in;
    private final OutputStream out;
    public static final int CHUNKSIZE=512;

    public Consumer( InputStream in, OutputStream out ){
        this.out = out;
        this.in = in;
    }

    public void run(){
        byte[] chunk = new byte[CHUNKSIZE];

        for( int bytesRead; -1 != (bytesRead = in.read(chunk,0,CHUNKSIZE) );;){
            out.write(chunk, 0, bytesRead);
        }
        out.close();
    }
}