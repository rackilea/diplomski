ArrayList<int[]> arrayList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    while (scan.hasNext()) {
        String str = scan.nextLine();
        String[] ss = str.split(" ");
        int[] zz = new int[ss.length];
        for (int i = 0; i < ss.length; i++)
            zz[i] = Integer.parseInt(ss[i]);
        arrayList.add(zz);
    }
    int[][] arr = arrayList.toArray(new int[0][0]);