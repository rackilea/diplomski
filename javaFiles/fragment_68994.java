byte b = (byte) 0x1c;
        byte c = (byte) 0xff;

        char a = (char) (Byte.toUnsignedInt(b) + Byte.toUnsignedInt(c));
        char d = (char) (Byte.toUnsignedInt(b) - Byte.toUnsignedInt(c));

        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toHexString(d));

        if(a > 0xff) {
            System.out.println("Add Carry");
        }

        if(d > 0xff) {
            System.out.println("Sub Carry");
        }

        if((Byte.toUnsignedInt(b) & 0xf) + (Byte.toUnsignedInt(c) & 0xf) > 0xf) {
            System.out.println("Add Aux Carry");
        }

        if((Byte.toUnsignedInt(b) & 0xf) + (Byte.toUnsignedInt((byte) ~c) & 0xf) + 1 > 0xf) {
            System.out.println("Sub Aux Carry");
        }