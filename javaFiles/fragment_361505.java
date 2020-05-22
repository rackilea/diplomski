for (;;) {
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            UUID.randomUUID();
        }
        System.out.println(System.currentTimeMillis() - t0);
    }