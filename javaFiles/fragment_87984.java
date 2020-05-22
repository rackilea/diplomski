public class Test {

     public static void main(String[] args) throws Throwable  {
        for(int i = 0; i < 3; i++) {
           ProcessRunner pr = new ProcessRunner(args);
           pr.start();
           // wait for 100 ms
           pr.join(100);
           // process still going on? kill it!
           if(!pr.isDone())  {
              System.err.println("Destroying process " + pr);
              pr.abort();
           }
        }
     }

     static class ProcessRunner extends Thread  {
        ProcessBuilder b;
        Process p;
        boolean done = false;

        ProcessRunner(String[] args)  {
           super("ProcessRunner " + args); // got lazy here :D
           b = new ProcessBuilder(args);
        }

        public void run()   {
           try   {
              p = b.start();

              // Do your buffered reader and readline stuff here

              // wait for the process to complete
              p.waitFor();
           }catch(Exception e) {
              System.err.println(e.getMessage());
           }finally {
              // some cleanup code
              done = true;
           }
        }

        int exitValue() throws IllegalStateException  {
           if(p != null)  {
              return p.exitValue();
           }         
           throw new IllegalStateException("Process not started yet");
        }

        boolean isDone()  {
           return done;
        }

        void abort()   {
           if(! isDone()) {
              // do some cleanup first
              p.destroy();
           }
        }
     }
  }