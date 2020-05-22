public static byte[] readCard( ResponseAPDU r, CardChannel channel, String fid){
ByteArrayOutputStream dataResponseBuffer = new ByteArrayOutputStream();
try {
    //r = channel.transmit(new CommandAPDU(0x00, 0x84, 0x00, 0x00,  OperationHelper.hexToByteAr("6f,07,00,00,00,08,00,00,00,00,00,a4,02,0c,02,05,04")));
    /**
     *  GetParameters
     *
     *  Headers
     *  CLA - 00
     *  INS - A4
     *  P1 - 02
     *  P2 - 0C
     *  DATA - 00,02         //6C,00,00,00,00,08,01,00,00,00
     *  dataOffset - 00
     *  dataLength - length of trama
     *
     */
    //r = channel.transmit(new CommandAPDU(0x00, 0xA4, 0x02, 0x0C,  OperationHelper.hexToByteAr("00,02"), 0x00, 0x02));          
    if (!fid.equals("00,02") && !fid.equals("00,05"))
        //select MF - Only positioning
        r = channel.transmit(new CommandAPDU(0x00, 0xA4, 0x04, 0x0C, OperationHelper.hexToByteAr("ff,54,41,43,48,4f"), 0x00, 0x06));
    // select EF
    r = channel.transmit(new CommandAPDU(0x00, APDUCommand.SELECT_FILE.getCommand(), 0x02, 0x0C, OperationHelper.hexToByteAr(fid), 0x00, 0x02));
    boolean end = true;
    int p1 = 0x00;
    int p2 = 0x00;
    Byte le = Byte.valueOf((byte) 255);
    int size = 0x00;
    do {
        r = channel.transmit(new CommandAPDU(0x00, APDUCommand.READ_BINARY.getCommand(), p1, p2, (le < 0) ? le & 255 : le));
        switch (r.getSW1()) {
            case 0x90:
                dataResponseBuffer.write(r.getData());
                size += (le < 0) ? le.intValue() & 255 : le.intValue();
                byte[] offsetarray = ByteBuffer.allocate(4).putInt(size).array();
                p1 = (offsetarray[2] < 0) ? offsetarray[2] & 255 : offsetarray[2];
                p2 = (offsetarray[3] < 0) ? offsetarray[3] & 255 : offsetarray[3];
                break;
            case 0x67: // dec 103                   
                break;
            // normal process XX = number of bytes for response enabled
            case 0x61:
            /*
             nuevaLong = Byte.valueOf(codigoError[1]);
             */
                break;
            // incorrect parameters (out of EF)
            case 0x6a:
                if (r.getSW2() == 0x86)
                    System.out.println("Parameters P1-P2 incorrects");
                break;
            // incorrect long, sw2 = exact long. If not return field data
            case 0x6c: //dec 108
                //nuevaLong = Byte.valueOf(codigoError[1]);
                if (r.getSW2() == 0x86)
                    System.out.println("Parameter P1-P2 incorrects");
                break;
            case 0x69: //dec 108
                end = false;
                break;
            case 0x6b: //dec 107
                end = false;
                /*
                int div = (le < 0)? le.intValue() & 255: le.intValue() ;
                size -= div;
                le = Byte.valueOf((byte) (div / 2));
                size += le;
                if (le.byteValue() == (byte) 0) {
                    le = Byte.valueOf((byte) 1);
                    end = false;
                }
                offsetarray = ByteBuffer.allocate(4).putInt(size).array();
                 entero = Integer.valueOf(byteArraySize4ToInt(offsetarray) );
                p1 = (offsetarray[2] < 0)? offsetarray[2] & 255: offsetarray[2];
                p2 = (offsetarray[3] < 0)? offsetarray[3] & 255: offsetarray[3];
                */
                break;

            default:
                break;
        }
    } while (end);
} catch (CardException e1) {
    e1.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
return dataResponseBuffer.toByteArray();