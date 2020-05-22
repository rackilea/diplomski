if (one.length != two.length) {
    throw new IllegalArgumentException("unequal lengths");
}
int length = one.length; // or two.length
byte[] sum = new byte[length];
for (int i = 0; i<length; i++) {
    sum[i] = one[i] + two[i];
}