static final boolean PROFILE = Boolean.getBoolean("VictimZero.PROFILE");

 long startTime;
 if (PROFILE)
    startTime = System.nanoTime();

 ... run some code ...

 if (PROFILE) {
    long enTime = System.nanoTime();
    System.out.printf("Code took %.3f seconds%n", (endTime - startTime)/1e9);
 }