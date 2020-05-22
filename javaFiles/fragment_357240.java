public static void displayIntCount(int[] counts)
{
     for (int i = 0; i < counts.length; i++) {
          if (counts[i] != 0) {
              System.out.println((i+1) +" - " +counts[i] + " Times");
          }
     }
}