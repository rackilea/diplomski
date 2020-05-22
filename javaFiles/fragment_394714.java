class UDPTest extends UDPDataExchange {

public static void main(final String args[]) throws Exception {
    final int UDPClientConcordiaPortNumber = 9876;
    final int UDPClientMcgillPortNumber = 9890;
    final int UDPClientDawsonPortNumber = 9891;
    final UDPTest McgillServer = new UDPTest();
    final UDPTest DawsonServer = new UDPTest();
    final Thread t1 = new Thread() {
        @Override
        public void run() {
            McgillServer.responseData(UDPClientMcgillPortNumber);
        }
    };
    t1.setDaemon(true);
    t1.start();
    final Thread t2 = new Thread() {
        @Override
        public void run() {
            DawsonServer.responseData(UDPClientDawsonPortNumber);
        }
    };
    t2.setDaemon(true);
    t2.start();

    final UDPTest concordiaTest = new UDPTest();

    System.out.println("Attemping to connect to " + IPAddress
            + ") via UDP port" + UDPClientConcordiaPortNumber);

    final String concordiaData = "Hello from concordia";
    System.out.println("Sending data  " + concordiaData.length()
            + " bytes to server.");

    concordiaTest.requestData(UDPClientMcgillPortNumber, concordiaData);
    concordiaTest.requestData(UDPClientDawsonPortNumber, concordiaData);

}