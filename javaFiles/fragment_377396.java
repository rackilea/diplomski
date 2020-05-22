static int test(int a, int b, int c, int d) {
    return
            a
           +b+test(a,b,c,d)
           +c
           +d+test(a,b,c,d);
}