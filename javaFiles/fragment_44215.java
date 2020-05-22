Start service:btspp://localhost:0000110100001000800000805f9b34fb;name=EchoServer;authenticate=false;encrypt=false;
MAC 402CF454215C
Waiting for incoming connection...
Client Connected...
Exception Occured: java.io.EOFException
BlueCove stack shutdown completed
java.io.EOFException
    at java.io.DataInputStream.readChar(Unknown Source)
    at examples.bluetooth_spp_server.EchoServer.<init>(EchoServer.java:30)
    at examples.bluetooth_spp_server.EchoServer.main(EchoServer.java:42)