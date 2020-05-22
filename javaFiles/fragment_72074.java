private static int[] other = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
public static int invert( int n ){
    int units = n % 10;
    n /= 10;
    int inv = other[units];
    if( n == 0 ) return inv;
    return inv < 0 ? -1 : invert( n )*10 + inv;
}