int numOfBytes = 4;  // or 8 64bit JVM maybe ?
    int GiB = (1024*1024*1024)/numOfBytes;
    int MiB = GiB/1024;
    int KiB = MiB/1024;

    String[] a = new String[2*GiB+ 662*MiB +1023*KiB+252 /* 1008 bytes*/ ]; 
    // after first allocation JVM allowed me smaller ones
    String[] b = new String[59*MiB +613*KiB+ 220/* 880 bytes*/];
    String[] c = new String[4*MiB];
    //   String[] d = new String[1]; <-- fails here