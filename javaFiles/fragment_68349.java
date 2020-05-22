long t0 = System.currentTimeMillis();
    for(int i = 0; i < 1000; i++) {
        byte[] a1 = new byte[0];
        long mem1 = unsafe.allocateMemory(1000000);
        unsafe.putLong(a1, 12, mem);
        unsafe.putInt(a1, 8, 1000000);
    }
    System.out.println(System.currentTimeMillis() - t0);