public class Receiver implements Runnable {

    private static final int PACKETSIZE = 48;

    private final ConcurrentLinkedQueue<IReceiverListener> listeners = new ConcurrentLinkedQueue<>();

    private volatile DatagramSocket socket;
    private volatile int port;

    public Receiver(int port) {
        this.port = port;
    }

    public void addReceiverListener(IReceiverListener listener) {
        listeners.add(listener);
    }

    public void updatePort(int port) {
        this.port = port;
        DatagramSocket socket = this.socket;
        if (socket != null) {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                receiveLoop(new DatagramSocket(port));
            }
        } catch (IOException e) {
            // handle error
        }
    }

    private void receiveLoop(DatagramSocket newSocket) throws IOException {
        try (DatagramSocket socket = newSocket) {
            this.socket = newSocket;
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);
                socket.receive(packet);
                process(packet);
            }
        } catch (SocketException e) {
            // port was changed -> return and restart with a new socket
        } finally {
            this.socket = null;
        }
    }

    private void process(DatagramPacket packet) {
        update(new String(packet.getData()), packet.getAddress().toString());
    }

    private void update(String data, String adress) {
        for (IReceiverListener listener : listeners) {
            listener.receiveConsoleData(data, adress);
            if (data.indexOf("active") > -1) {
                listener.incrementWatchDog();
            }
        }
    }
}