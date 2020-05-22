public class UDPServer extends Thread {

    private SocketUDPCommunication comm;
    private UDPClient udpClient;
    private SharedWaitingThreads waitingThreads;

    public UDPServer(SharedWaitingThreads waitingThreads) {
        comm = new SocketUDPCommunication();
        udpClient = new UDPClient();
        this.waitingThreads = waitingThreads;
    }


    @Override
    public void run() {
        DatagramPacket response;
        try {
            comm.setPort(Utils.UDP_SERVER_PORT);
            comm.createSocket();

            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Waiting for clients to connect on port:" + comm.getSocket().getLocalPort());
                try {
                    response = comm.receiveResponse();
                } catch (SocketTimeoutException e) {
                    continue;
                }                           
                InetAddress ip = response.getAddress();
                int port = response.getPort();

                byte[] byteSend = comm.discardOffset(response);

                byte[] header = new byte[Utils.STD_HEADER_SIZE];
                Utils.getCleanHeader(byteSend, header);
                byte type = header[12];

                ResponseToWait r1;
                if(type == Utils.TYPE_CONFIG_REPORT) {
                    ProtocolConfig pc = new ProtocolConfig();
                    pc.parseFrame(byteSend);
                    int mapType = pc.getPayload()[0];
                    int idElement = pc.getPayload()[1];
                    r1 = new ResponseToWait(ip.getHostAddress(), port, Utils.TYPE_CONFIG, null);
                    if(checkPendingRequests(r1, null)) {
                        System.out.println("Resending config");
                        continue;
                    }
                    waitingThreads.answerWaitingThread(r1, true);
                }else if(type == Utils.TYPE_STATUS_REPORT) {
                    ProtocolStatus protocol = new ProtocolStatus();

                    r1 = new ResponseToWait(ip.getHostAddress(), port, Utils.TYPE_STATUS);
                    if(checkPendingRequests(r1, statusTest)) continue;
                    byte[] frame;
                    if(statusTest.equals(StatusTest.FINALIZED)) {
                        System.out.println("Test finalized. Waking threads");
                        r1 = new ResponseToWait(ip.getHostAddress(), port, Utils.TYPE_STATUS, null);
                        //Free possible waiting threads
                        ResponseToWait res1 = waitingThreads.answerWaitingThread(r1, false);

                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Unable to process client request: " + e.getMessage());
        } catch (IllegalArgumentException ex) {
            System.err.println("Illegal Argument: " + ex.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            comm.closeConnection();
        }
    }

    private boolean checkPendingRequests(ResponseToWait rw, StatusTest status) {
        boolean resend = false;
        System.out.println("Status: " + status);
        synchronized(waitingThreads) {
            for(ResponseToWait r : waitingThreads.getQueue()) {
                if(r.getResponseType() == Utils.TYPE_CONFIG && r.getIp().equals(rw.getIp())) {
                    udpClient.send(r.getIp(), r.getPort(), r.getFrame());
                    resend = true;
                }
                if(r.getResponseType() == Utils.TYPE_STATUS && r.getIp().equals(rw.getIp())){
                    udpClient.send(r.getIp(), r.getPort(), r.getFrame());
                    resend = true;  
                }
            }
        }
        return resend;
    }

    @Override
    public void interrupt() {
        super.interrupt();
        comm.closeConnection();
    }

}