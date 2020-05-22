private void exec(String command) throws IOException{
    Process pro = Runtime.getRuntime().exec(command, null);

    inStream = pro.getInputStream();
    inErrStream = pro.getErrorStream();
    outStream = pro.getOutputStream();

    // Thread that reads process output
    Thread outStreamReader = new Thread(new Runnable() {
        public void run() {
            try {
                String line = null;
                BufferedReader in = new BufferedReader(new InputStreamReader(inStream));                        
                while ((line = in.readLine()) != null) {
                    println(line);                       
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Exit reading process output");
        }
    });
    outStreamReader.start();

    // Thread that reads process error output
    Thread errStreamReader = new Thread(new Runnable() {
        public void run() {
            try {
                String line = null;           
                BufferedReader inErr = new BufferedReader(new InputStreamReader(inErrStream));
                while ((line = inErr.readLine()) != null) {
                    println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Exit reading error stream");
        }
    });
    errStreamReader.start();

    // Thread that waits for process to end
    Thread exitWaiter = new Thread(new Runnable() {
        public void run() {
            try {
                int retValue = pro.waitFor();
                println("Command exit with return value " + retValue);
                // close outStream
                outStream.close();
                outStream = null;
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
    });
    exitWaiter.start();
}