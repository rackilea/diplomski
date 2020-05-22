public static void ranNums() {
   for (int i = 0; i < ran.length; i++) {
      ran[i] = r.nextInt(10);
      System.out.print(ran[i] + " ");
      counter[ran[i]]++;
   }
}