public void selsort() {
    int j = 0, i, k;
    int low;
    for (k = 0; k < ele; k++) {
        low = j;
        for (i = j; i < ele; i++)
            if (a[i] < a[low]) {
                low = i;
            }
        if (j != low) {
            int temp = a[j];
            a[j] = a[low];
            a[low] = temp;
        }
        j++;
    }
}