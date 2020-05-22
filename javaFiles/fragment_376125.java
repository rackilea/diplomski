for (int j = 0; j < imageInByte.length; j+=2) {
        byte h = (byte) (imageInByte[j] & 0xF0);
        byte h2 = (byte) (imageInByte[j+1] & 0xF0);
        byte l = (byte) (imageInByte[j] & 0x0f);
        byte l2 = (byte) (imageInByte[j+1] & 0x0f);
        high[j/2] = h|(h2>>4);
        low[j/2] = (l<<4)|l2;
  }