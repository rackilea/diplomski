long[] data = new long[1<<24]; // 8 * 16MB
volatile long blackhole;

void saturateBus() {
    long sum = 0;
    for (long x : data) sum += x;
    blackhole = sum;
}