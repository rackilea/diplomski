int newlen = 0;
for( int[] a: list ){
    newlen += a.length;
}
int[] out = new int[newlen];
int pos = 0;
for( int[] a: list ){
    System.arraycopy( a, 0, out, pos, a.length );
    pos += a.length;
}