public static int maxPalindrome(char ch[], int i, int j, int cache[][]) {
   if (cache[i][j] != -1) {
       return cache[i][j];
   }

   if (i == j) {
       return cache[i][j] = 1;
   }

   if (j - i  == 1) {
       return cache[i][j] = (ch[i] == ch[j] ? 2 : 0);
   }

   int max = 0;
   //easy if they are equal
   if (ch[i] == ch[j]) {
       int inCount = maxPalindrome(ch, i + 1, j - 1, cache);
        max = inCount == 0 ? 0 : 2 + inCount;
   } 
   //there are 2 ways to go step 3
   maxPalindrome(ch, i + 1, j, cache);

   maxPalindrome(ch, i, j - 1, cache);
   return cache[i][j] = max;
}

public static void main(String[] args) {
    String str = "abbzbasddeeaaaccffertrecca"; 
    char ch[] = str.toCharArray();
    int cache[][] = new int[ch.length][ch.length];
    for (int row[] : cache) {
        Arrays.fill(row, -1);
    }
    maxPalindrome(ch, 0, ch.length - 1, cache);
    //print all the pallindromes
    for (int i = 0; i < cache.length; ++i) {
        for (int j = 0; j < cache.length; ++j) {
            if (cache[i][j] > 0) {
                System.out.println(str.substring(i, j+1) + " " + cache[i][j]);
            }
        }
    }

}