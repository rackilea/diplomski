double[] d = getMonthlyInterest();
double value = 0d;    

for (int i = 0; i < d.length; i++) {
    value += d[i]; // d[i] returns value which has i index in array d.
}