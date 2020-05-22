dos.write("STARTTLS\r\n".getBytes());

SSLSocket sslSocket = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket(socket, "mail.arcor.de", 587, true);
dos = new DataOutputStream(sslSocket.getOutputStream());
dis = new DataInputStream(sslSocket.getInputStream());

sslSocket.startHandshake();

new Thread(() -> {readInputRun();}).start();

dos.write(("EHLO " + InetAddress.getLocalHost().getHostAddress() + "\r\n").getBytes());

dos.write("QUIT\r\n".getBytes());