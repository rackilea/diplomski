if (pduRequest.getCommandId() == SmppConstants.CMD_ID_DELIVER_SM) {
         DeliverSm mo = (DeliverSm) pduRequest;
         int length = mo.getShortMessageLength();
         Address source_address = mo.getSourceAddress();
         Address dest_address = mo.getDestAddress();
         byte[] shortMessage = mo.getShortMessage();
         String SMS= new String(shortMessage);
        }