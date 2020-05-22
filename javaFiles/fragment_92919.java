while ((response = queue.poll()) != null){

            //LOGGER.info(response.toString());
            int[] payload = xbeeReceiver.readPacket();

            dbHandler.updateDB(payload);

            int[] payloadToSend2 = dbHandler.retrieveDataFromFB();
            xbeeReceiver.sendPacket(payloadToSend2);

            try {
                XBee xbee = xbeeReceiver.getXbee();
                response = xbee.getResponse();
                queue.add(response);
            } catch (XBeeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }