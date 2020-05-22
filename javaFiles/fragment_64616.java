long result = 7534534523L;
long divisor = 1;
for (int i = 2; i < result; i++) {
    if (result % i == 0) {
        divisor = i;
        break;
    }
}
System.out.println(result + "/" + divisor + "=" + (result / divisor));