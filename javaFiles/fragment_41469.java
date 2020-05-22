TreeSet<Long[]> ts = new TreeSet<Long[]>(
   new Comparator<Long[]>() {
      public int compare(Long[] a, Long[] b)
      {
         return Long.compare(a[0], b[0]);
      }
   }
);