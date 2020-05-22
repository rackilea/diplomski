public void findComputers(View v) {
    try {
        int port = 4444;
        String multicastAddr = "224.168.1.0";

        DatagramSocket socket = new DatagramSocket(port);
        socket.setSoTimeout(300);
        InetAddress group = InetAddress
                .getByName(multicastAddr);
        DatagramPacket packet = new DatagramPacket(new byte[] { 1 }, 1,
                group, port);
        socket.send(packet);

        // Give time to the servers to respond
        Thread.sleep(100);

        while (true) {
            try {
                // Listen for the servers responses
                byte[] buffer = new byte[256];
                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String data = new String(packet.getData());
                // Information sent from servers include the host's name
                // and IP addres separated by a semicolon.
                String[] parts = data.split(";");

                // Add a server to the result list.
                Computer computer = new Computer(parts[1].trim(),
                        parts[0].trim());
                this.computers.put(computer.getName(), computer);
            } catch (InterruptedIOException ex) {
                break;
            }
        }
        socket.close();
    } catch (SocketException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    String output = "No computers found.";

    if (this.computers.size() > 0) {
        output = this.computers.size() + " computer(s) found.";
        this.fillComputers();
    }

    Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
}