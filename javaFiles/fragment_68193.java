Random r = new Random();
c = new int[3];
int[] t = new int[3];
for (int i = 0; i < c.length; ++i) {
    for (int j = 0; j < t.length; ++j0 {
        t[j] = r.nextInt(10) + 1;
    }
    c[i] = t;
    t = new int[3];
}