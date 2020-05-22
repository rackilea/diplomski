private int n = 6;

public int fact(){
    int i = 0;
    int f = 1;

    /* loop invariant: 0 <= i <= n && f == i! */
    /* PRE: i == 0 && f == i! */
    while (i < n) {
        i = i + 1;
        f = f * i;
    }
    /* POST: i == n && f == i! */

    return f;
}