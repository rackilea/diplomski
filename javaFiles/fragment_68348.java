long t0 = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++) {
//          byte[] a1 = new byte[1];
            byte[] a1 = new byte[1000000];
        }
        System.out.println(System.currentTimeMillis() - t0);