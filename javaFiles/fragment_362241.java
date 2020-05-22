public static void addcount(Averager a, int i) {
    a.total += i;
    a.count++;
}
public static void combine(Averager dst, Averager src) {
    dst.total += src.total;
    dst.count += src.count;
}