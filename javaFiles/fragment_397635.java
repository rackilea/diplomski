public double calculate(int size, int count) {       
    int max = 365;
    int birthDays[] = new int[max];
    Random rnd = new Random();
    int hits = 0;
    for(int j = 1; j <= count; j++) {
        Arrays.fill(birthDays, 0);
        rnd.setSeed(j);
        for(int i = 0; i < size; i++) {
            int x = rnd.nextInt(max);
            birthDays[x]++;
            if(birthDays[x] >=2 ) {
                hits++;
                break;
            }
        }

    }
    return (hits/count) * 100;

}