private static ByteBuffer intBuffer = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE);

    public static byte[] intToBytes(int Value)
    {
        intBuffer.clear(); //THIS IS IMPORTANT, YOU NEED TO RESET THE BUFFER
        intBuffer.order(ByteOrder.LITTLE_ENDIAN);
        intBuffer.putInt(Value);
        return intBuffer.array();
    }