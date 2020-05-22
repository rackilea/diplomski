NetworkInterface nif = NetworkInterface.getByName("bge0");
Enumeration nifAddresses = nif.getInetAddresses();

Socket soc = new java.net.Socket();
soc.bind(nifAddresses.nextElement());
soc.connect(new InetSocketAddress(address, port));