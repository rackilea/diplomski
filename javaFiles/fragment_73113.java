//      long val = 0xAF00000000000000L;
        long val = 0x0000000000000001L;
        int n = 2;
        int count = 0;
        int i = 0;
        while (i < 65 && count < n) {
            if ((val & 0x8000000000000000L) != 0) {
                count++;
            }
            val = val << 1;
            i++;
        }