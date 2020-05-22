int[] a = {2, 2, 2};
int[] b = {1, 1, 1};
int[] c = new int[a.length];

for(int i = 0; i < a.length; i++){
    c[i] = a[i] - b[i];
}