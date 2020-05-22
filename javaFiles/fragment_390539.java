@Override
public void messageReceived(IoSession session, Object message)
    throws Exception {
if (message instanceof IoBuffer) {
    InetSocketAddress inetSocketAddress = (InetSocketAddress) session.getServiceAddress();
    int portNumber = inetSocketAddress.getPortNumber();
    String msg = "data received in port "+ portNumber;
    System.out.println(msg);
}