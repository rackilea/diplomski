public class Esercizio29 {static void  join(char[] a, int l, int m, int u) {
    char[] b = new char[u]; // replaced redundent [u - 1 + 1]
    int i = l, j = m + 1, k = 0;

    while (i <= m && j <= u) 
        if (a[i] <= a[j])
            b[k++] = a[i++];
        else
            b[k++] = a[j++];
    while (i <= m && k < b.length) // integrity check
        b[k++] = a[i++];
    while (j <= u && k < b.length) { // integrity check
        b[k++] = a[j++];  
    }
    for (k = 0; k <= u - l && k < a.length && k < b.length; k++) // integrity checks
        a[k + l] = b[k];
}