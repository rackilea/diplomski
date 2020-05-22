void combos(int pos, char[][] c, String soFar) {
    if (pos == c.length) {
         System.out.writeln(soFar);
         return;
    }
    for (int i = 0 ; i != c[pos].length ; i++) {
        combos(pos+1, c, soFar + c[pos][i]);
    }
}