public class Test {
    public static void main(String[] args) throws Exception {            
        String startDir = System.getProperty("user.dir"); // start in current dir (change if needed)
        ProcessBuilder pb = new ProcessBuilder("adb","logcat","-d");
        pb.directory(new File(startDir));  // start directory
        pb.redirectErrorStream(true); // redirect the error stream to stdout
        Process p = pb.start(); // start the process
        // start a new thread to handle the stream input
        new Thread(new ProcessTestRunnable(p)).start();
        p.waitFor();  // wait if needed
    }

    // mimics stream gobbler, but allows user to process the result
    static class ProcessTestRunnable implements Runnable {
        Process p;
        BufferedReader br;

        ProcessTestRunnable(Process p) {
            this.p = p;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(p.getInputStream());

                br = new BufferedReader(isr);

                String line = null;
                while ((line = br.readLine()) != null)
                {
                    // do something with the output here...                        
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}