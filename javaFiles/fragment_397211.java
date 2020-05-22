List<int[]> list = new ArrayList<>();//create a list or arrays
for (int i = 0; i < n; i++) {

    int variable = sc.nextInt();
    int[] array = new int[variable];
    for (int j = 0; j < variable; j++) {
        array[j] = sc.nextInt();
    }

    list.add(array);//add your array to your list
}