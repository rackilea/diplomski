private static byte coinFlip(byte theByte)
    {
        Integer mode = new Random().nextInt(3);
        byte value = mode.byteValue();
        return (byte)(theByte ^ (value << 3));
    }