list2.removeAll(list1);

   for(String w : list2) {
          map.put(w, 0);
    }

    for(Entry<String, Integer> e : map.entrySet) {
          int n = Collections.frequency(list2, e.getKey());
          e.setValue(n);
    }