int findIndex(String str, int start, String[] array) {
   for (int i=start;i<array.length;i++) {
      if (array[i].equals(str)) {
          return i;
      }
   }
   return -1;
}