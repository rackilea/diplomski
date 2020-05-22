else {
    for(int j = 0; j < 7; j++)
    {
        int num = rand.nextInt(100);
        list[j] = num;
    }
    System.out.println(Arrays.toString(list));
    outer.add(list);
    System.out.println(outer.size());
    System.out.println(i);
    System.out.println(Arrays.toString(outer.get(i)));
}