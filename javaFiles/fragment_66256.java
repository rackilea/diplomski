byte[] sendData = new byte[15];
String name = nameField.getText();
sendData = name.getBytes();
        for(;;){
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9877);
            serverSocket.send(sendPacket);
            Thread.sleep(1000);
        }