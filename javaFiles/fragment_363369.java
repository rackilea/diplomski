System.out.printf("%x - %x - (byte)%x - (int)%x\n", 
                   (byte)0x80, 
                   (byte)0xf, 
                   (byte)((byte)0x80|(byte)0xf), 
                    (int)((byte)0x80|(byte)0xf));

OUTPUT:
80 - f - (byte)8f - (int)ffffff8f