boolean val = true; 
for (int j = 0; j < d; j++) {
    if (arr[i] == b[j]) {
        val = false;
        break;
    }
}
if (val) {
    a[k] = arr[i];
    k = k + 1;
}