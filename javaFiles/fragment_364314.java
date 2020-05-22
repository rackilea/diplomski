public class InputStreamLineBuffer{
    private InputStream inputStream;
    private ConcurrentLinkedQueue<String> lines;
    private long lastTimeModified;
    private Thread inputCatcher;
    private boolean isAlive;

    public InputStreamLineBuffer(InputStream is){
        inputStream = is;
        lines = new ConcurrentLinkedQueue<String>();
        lastTimeModified = System.currentTimeMillis();
        isAlive = false;
        inputCatcher = new Thread(new Runnable(){
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder(100);
                int b;
                try{
                    while ((b = inputStream.read()) != -1){  
                        // read one char
                        if((char)b == '\n'){
                            // new Line -> add to queue
                            lines.offer(sb.toString());
                            sb.setLength(0); // reset StringBuilder
                            lastTimeModified = System.currentTimeMillis();
                        }
                        else sb.append((char)b); // append char to stringbuilder
                    }
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    isAlive = false;
                }
            }});
    }
    // is the input reader thread alive
    public boolean isAlive(){
        return isAlive;
    }
    // start the input reader thread
    public void start(){
        isAlive = true;
        inputCatcher.start();
    }
    // has Queue some lines
    public boolean hasNext(){
        return lines.size() > 0;
    }
    // get next line from Queue
    public String getNext(){
        return lines.poll();
    }
    // how much time has elapsed since last line was read
    public long timeElapsed(){
        return (System.currentTimeMillis() - lastTimeModified);
    }
}