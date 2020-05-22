private void exec(String command) throws IOException{
    Process pro = Runtime.getRuntime().exec(command, null);

    inStream = pro.getInputStream();
    inErrStream = pro.getErrorStream();
    outStream = pro.getOutputStream();

    InputStreamLineBuffer outBuff = new InputStreamLineBuffer(inStream);
    InputStreamLineBuffer errBuff = new InputStreamLineBuffer(inErrStream);

    Thread streamReader = new Thread(new Runnable() {       
        public void run() {
            // start the input reader buffer threads
            outBuff.start();
            errBuff.start();

            // while an input reader buffer thread is alive
            // or there are unconsumed data left
            while(outBuff.isAlive() || outBuff.hasNext() ||
                errBuff.isAlive() || errBuff.hasNext()){

                // get the normal output if at least 50 millis have passed
                if(outBuff.timeElapsed() > 50)
                    while(outBuff.hasNext())
                        println(outBuff.getNext());
                // get the error output if at least 50 millis have passed
                if(errBuff.timeElapsed() > 50)
                    while(errBuff.hasNext())
                        println(errBuff.getNext());
                // sleep a bit bofore next run
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                 
            }
            System.out.println("Finish reading error and output stream");
        }          
    });
    streamReader.start();

    // remove outStreamReader and errStreamReader Thread
    [...]
}