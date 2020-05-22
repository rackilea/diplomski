public class YUV4MPEGPipeParser extends Thread {

    ...

    // optimal size of buffer for reading from pipe stream :-)
    private static final int BUFSIZE = PipedInputStream.PIPE_SIZE; 

    public void run() {
        try {
            byte buffer[] = new byte[BUFSIZE];
            int len = 0;
            while ((len = is.read(buffer, 0, BUFSIZE) != -1) {
                // we have valid data available 
                // in first 'len' bytes of 'buffer' array.

                // do stuff.... like write out YUV frames
            }
         } catch ...
     }
 }