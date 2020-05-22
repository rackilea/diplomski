class MultiCastServerThread extends Thread {
    protected DatagramSocket socket = new DatagramSocket();
    protected String multicastGroupId = "224.0.0.224";
    protected long delay = 1000l;
    protected int port = 2244;

    public MultiCastServerThread() throws IOException {
        super("SpeakServerThread");
    }

    public void run() {
        InetAddress group = InetAddress.getByName(multicastGroupId);
        while (true) {
            try {
                byte[] buf = new byte[256];
                buf = "Message".getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, port);
                socket.send(packet);
                sleep(delay);
            }catch (InterruptedException e){
            }catch (IOException e) {
                e.printStackTrace();
                socket.close();
                break;
            }
        }
    }
}