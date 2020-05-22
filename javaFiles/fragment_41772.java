List<int[]> list = new ArrayList<>();
    for (int i = 0; i < count.length; i++) {
        if (count[i] > 0)
            list.add(new int[] {i , count[i]});
    }
    Collections.sort(list, Comparator.comparing(a -> a[1]));
    for (int[] a : list) {
        System.out.println((char)a[0] + ": " + a[1]);
    }