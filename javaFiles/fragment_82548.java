byte packet[] = new byte[5];
    for (byte messageNumber = 0; messageNumber <= 20; messageNumber++)
    {
        packet[0] = CLIENT_ID; //SOURCE
        packet[1] = randomDestination(); //DESTINATION
        packet[3] = messageNumber; //DATA
        packet[4] = messageNumber;
        //Need more data?

        // ********************
        packet[2] = (byte) 0; // <<<<<< You have to set it to zero
        // ********************

        packet[2] = computeCheckSum(packet); //COMPUTE CHECKSUM
        send(packet); //SEND PACKET
        Thread.sleep(4000); //WAIT TO SEND NEXT PACKET
    }