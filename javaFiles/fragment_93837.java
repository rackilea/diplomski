int BUFFER_SIZE = 1000;

buf.mark(BUFFER_SIZE);
buf.readLine();  // returns the GET
buf.readLine();  // returns the Host header
buf.reset();     // rewinds the stream back to the mark
buf.readLine();  // returns the GET again