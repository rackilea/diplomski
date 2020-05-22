int count = 0, sumA = 0, sumB = 0, sumC = 0;
for (Value v : values) {
    sumA += v.getA();
    sumB += v.getB();
    sumC += v.getC();
    count++;
}
double avgA = ((double) sumA) / count;
double avgB = ((double) sumB) / count;
double avgC = ((double) sumC) / count;