final int CAPCITY = 4096;
final int PIPE_SIZE = 4096;

PipedOutputStream pout = new PipedOutputStream();
ByteArrayOutputStream bout = new ByteArrayOutputStream(CAPACITY);
MultiOutputStream multiOs= new MultiOutputStream(pout, bout);

PipedInputStream is = new PipedInputStream(pout, PIPE_SIZE);