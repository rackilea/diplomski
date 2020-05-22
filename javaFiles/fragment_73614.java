socket = new Socket();
socket.connect(new InetSocketAddress(ip, port), Connect_Timeout);

DataOutputStream DataOut = new DataOutputStream(socket.getOutputStream());
DataOut.writeBytes(message);
DataOut.flush();

socket.close();