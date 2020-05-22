Entry<Client, Integer> maxEntry = Collections.max(Score.entrySet(), 
       new Comparator<Entry<Client, Integer>>() {
            @Override
            public int compare(Entry<Client, Integer> o1, Entry<Client, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        }
  );