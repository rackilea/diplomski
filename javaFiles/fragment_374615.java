long val = 0;
     byte[] bytes = { -1, 12, 99, -121, -3, 123
     };
     for (int i = 0; i < bytes.length; i++) {
        // shift the val left by 8 bits first.
        // then add b.  You need to mask it with 0xFF to
        // eliminate sign extension to a long which will
        // result in an incorrect conversion.
        val = (val << 8) | ((i == 0 ? bytes[i]
              : bytes[i] & 0xFF));
     }
     System.out.println(val);