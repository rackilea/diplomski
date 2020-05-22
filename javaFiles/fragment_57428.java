int[] output;
int L1 = arg1.length;
int L2 = arg2.length;
if (L1 > L2) {
    output = new int[L2];
    for (int i = 0; i < L2; i++) {
        output[i] = arg1[i] + arg2[i];
    }
} else {
    output = new int[L1];
    for (int i = 0; i < L2; i++) {
        output[i] = arg1[i] + arg1[i];
    }
}
String result = Arrays.toString(output);
return result;
}