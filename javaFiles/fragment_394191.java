List<Integer> list = Arrays.asList(297, 720, 840, 903, 1110, 1170);
    Collections.sort(list);
    Integer min = list.get(0);
    Integer max = list.get(list.size() - 1);
    List<Integer> notes = new ArrayList<Integer>();
    for (Integer i : list) {
        notes.add(10 - (int) 9.0 * (i - min) / (max - min));
    }
    System.out.println(notes);