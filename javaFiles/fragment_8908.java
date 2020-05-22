List<Integer> list = Arrays.asList(1,2,3,6,9,4,2,9,7,2,8);
for (int z = 0; z < list.size() - 4; z++) {
    List<Integer> sublist = list.subList(z, z + 4);
    int           prod    = 1;
    for (int i : sublist)
        prod *= i;
    System.out.println(prod);
}