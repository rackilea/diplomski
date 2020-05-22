List<List<Integer>> L = new ArrayList<>();
    L.add(new ArrayList<Integer>());
    L.add(new ArrayList<Integer>());
    L.add(new ArrayList<Integer>());

    L.get(0).add(1);
    L.get(0).add(2);
    L.get(0).add(3);
    L.get(1).add(4);
    L.get(1).add(5);
    L.get(1).add(6);
    L.get(2).add(7);
    L.get(2).add(8);
    L.get(2).add(9);

    int[] last = L.stream().mapToInt(x -> x.get(x.size() - 1)).toArray();
    System.out.println(Arrays.toString(last));