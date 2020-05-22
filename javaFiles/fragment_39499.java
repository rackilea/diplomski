int[] concat = new int[a1.length * 2];
int index = 0;
for (int i = 0; i < a1.length; i++) {
    concat[index++] = a1[i];
    concat[index++] = a2[i];
}