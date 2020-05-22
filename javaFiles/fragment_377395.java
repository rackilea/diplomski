static int test(int a, int b, int c, int d) {
    return
            a
           +b
           +c+test(a,b,c,d)
           +d;
}