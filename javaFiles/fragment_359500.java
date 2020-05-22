public static void main(String[] args) {
    List<Triple<Integer, String, Integer>> list = new ArrayList<>();
    list.add(new Triple<Integer, String, Integer>(0, "first", 1));
    list.add(new Triple<Integer, String, Integer>(1, "second", 2));

    TripleList<Integer, String, Integer> elements = new TripleList<>();
    elements.add(0, "first", 1);
    elements.add(1, "second", 2);

    for (Triple<Integer, String, Integer> triple : elements) {
       System.out.println(triple.getKey() + "," + triple.getValue1() + "," + triple.getValue2());  
    }
  }