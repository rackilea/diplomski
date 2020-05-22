RPCMessage c = new RPCMessage();
//ByteBuffer bb = ByteBuffer.wrap(mData);
//int index = 0;
//c.setMessageType(bb.getShort(index)); 
c.setMessageType(MessageType.REPLY); // You can change this line as per your need
//index += 2;