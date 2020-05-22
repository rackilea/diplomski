for (int j = 0; j < 3; j++) {
    ArrayList<Integer> al = new ArrayList<Integer>();
    for (int i = 0; i < 5; i++) {
        al.add(i + j);
    }
    System.out.println(al);
    System.out.println(j);//key value
    map.put(j, al);
    System.out.println(map);
}