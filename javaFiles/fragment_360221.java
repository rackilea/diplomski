int MAX_NUMBER = 10;        
    List<Integer> list = Arrays.asList(1,1,2,2,2,2,2,5,5,7,9,10);
     HashSet<Integer> set = new HashSet<>();
    set.addAll(list);
    HashSet<List<Integer>> groups = new HashSet<>();

    for (int i = 0; i < list.size(); i ++)
    {
        List<Integer> group = new ArrayList<Integer>();
        group.add(list.get(i));
        int total = list.get(i);
        boolean occurrence = set.contains(MAX_NUMBER - list.get(i));
        if (occurrence) {
            group.add(MAX_NUMBER - list.get(i));
            groups.add(group);

        }
            group = new ArrayList<Integer>();
            group.add(list.get(i));
            for (int j = i+1; j < list.size(); j++) {
                if ((total + list.get(j)) < MAX_NUMBER) {
                    total += list.get(j);
                    group.add(list.get(j));
                    occurrence = set.contains(MAX_NUMBER - total);
                    if (occurrence) {
                        List<Integer> groupClone = new ArrayList<>();
                        groupClone.addAll(group);
                        group.add(MAX_NUMBER - total);
                        groups.add(group);
                        group = groupClone;
                    }
                }
                 if (total + list.get(j) == MAX_NUMBER) {
                    group.add(list.get(j));
                    groups.add(group);
                    break;
                }
                 if (total > MAX_NUMBER)
                    break;
            }
  }