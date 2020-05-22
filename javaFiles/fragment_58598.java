public static void main(String[] args) {
    RPCMessage c = new RPCMessage();
    //int buffSize = 0;
    c.setMessageType(MessageType.REPLY);
    //ByteBuffer bb = ByteBuffer.allocate(buffSize);
    short typeNum = (short) c.getMessageType().enumVar;
    //int index = 0;
    //bb.putShort(0,typeNum);
    //index+=2;

    System.out.println(typeNum);
}