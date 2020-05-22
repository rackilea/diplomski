// auto sorted because Integer implements Comparable
    SortedSet set = new TreeSet<Integer>();

   // asume MyObject implements Comparable
   SortedSet set = new TreeSet<MyObject>();

   // asume MyObject needs a special other sorting
   SortedSet set = new TreeSet<MyObject>(MyCustomComparator);