String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
char[] alpha = alphabets.toCharArray();
char[][] cipher = new char[6][5];
outerLoop : for(int i=0 ; i<cipher.length ; i++) {
   for(int j=0 ; j<cipher[0].length ; j++) {
       int k = i*cipher[0].length + j;
       if (k >= alpha.length) break outerLoop;
       cipher[i][j] = alpha[k];
   }
}