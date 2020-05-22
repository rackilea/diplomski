double temp = 1;
double result = 1;
for (int i = 1; true; i++) {
    temp *= x / i;
    result += temp;
    if (Math.abs(temp) < ACCURACY) break;
}
return result;