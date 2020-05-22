int candy(int n, int m) {

    int result = 0;

    while ((n > 1) && (m != 0))
    {
        result += n/m;
        n = (n+n%m)/m;
    }

    return result;
}