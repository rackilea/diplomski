public void openXbeeConnection(String portNumber){

        try {

            xbee.open(portNumber, 57600);
            xbee.addPacketListener(new PacketHandler());
            response = xbee.getResponse();
            queue.add(response);

        }   catch (XBeeException e) {

          System.out.println("" + portNumber + " - connection problems");

            e.printStackTrace();
        }    

    };