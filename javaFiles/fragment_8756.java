/* Global Declarations */
private Random o = new Random();
private int g = 0;

/* Logic */
private void loopMethod(anClass someName) {
    for (int k = 0; k < 50 + g; k++) {
        if(g == 50 || o.nextInt(100) == 1)
            k = 101;
        else
            /* Do Something */
    }
    g += 5;
}