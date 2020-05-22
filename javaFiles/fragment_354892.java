public class WriteFileData extends Thread {
    private LinkedBlockingQueue<byte[]> queue = new LinkedBlockingQueue<byte[]>();

    public void add(byte[] send) {
        queue.add(send);
    }

...
}