public void generate (int n) {
   int[] covered = new int[n];
   int[] list = new int[n];
   for (int i = 0; i < n; i++) {
      covered[i] = 0;
   }
   this.generate(n, covered, 0, list);
}
private void generate (int n, int[] covered, int i, int[] list) {
   int j = 0;
   while ((j < n) && (covered[j] == 1)) {
      j++;
   }
   if (j == n) {
      System.out.println(Arrays.toString(list));
      return;
   }
   covered[j] = 1;
   for (int k = 0; k < n; k++) {
      if (covered[k] == 0) {
         covered[k] = 1;
         list[i++] = j;
         list[i++] = k;
         this.generate(n, covered, i, list);
         i -= 2;
         covered[k] = 0;
      }
   }
   covered[j] = 0;
}