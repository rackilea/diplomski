public class ResultHandler {

    String host;
    Connection conn;
    BufferedReader reader = null;

    public ResultReader(String host) {
        this.host = host;
    }

    public void connect(<params>) throws Exception {

        // if you intend to reuse the object, just check that it was properly cleanedup before
        close();

        conn = new Connection(host);
        conn.connect();
        ... // authentication part

        // you might want to move the actual handling to a different method
        Session sess = conn.openSession();
        sess.execCommand("ascript");
        InputStream stdout = new StreamGobbler(sess.getStdout());
        br = new BufferedReader(new InputStreamReader(stdout));
    }

    public BufferedReader getReader() {
        return this.reader;
    }

    public void close() {
        If (reader != null) {
            reader.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public void finalize() {
        close();
    }
}


synchronized void runScript(<params>) {    

  ResultHandler handler;
  try {
        handler = new ResultHandler(host);
        handler.connect();

        // consume the reader for whatever you need to do

  } catch (Exception e) {
      e.printStackTrace();
  } finally {
    // or use try-with-resource and implement the proper interface for that
    if (handler != null) {
        handler.close();
     }
  }
}