long sum = 0;
long sumSquare = 0;
for(int c = 0 ; c < 10 ; c++) {
    long start = System.nanoTime();
    // do work
    long end = System.nanoTime();
    sum += end - start;
    sumSquare += Math.pow(end - start, 2);
}
double average = (sum * 1D) / 10;
double variance = (sumSquare * 1D) / 10 - Math.pow(average, 2);
double std = Math.sqrt(variance);