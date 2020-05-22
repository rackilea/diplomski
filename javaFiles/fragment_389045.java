private static void setLittleInt(byte[] bytes, int index, int value) {
        byte[] ins = IOMath.toBytes(value);
        bytes[index+3] = ins[0];
        bytes[index+2] = ins[1];
        bytes[index+1] = ins[2];
        bytes[index] = ins[3];
    }