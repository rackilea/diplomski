public static Comparator<Entry<Integer,?>> KeyComparator = new Comparator<Entry<Integer,?>>()
  {
     public int compare(Entry<Integer,?> o1, Entry<Integer,?> o2)
       {
         Integer key1 = o1.getKey();
         Integer key2 = o2.getKey();
         return key1.compareTo(key2);
       }
  }