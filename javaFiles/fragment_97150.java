String[] a = new String[] {"A", "B", "C"};
for (int mask = 0 ; mask != 1<<a.length ; mask++) {
    for (int i = 0 ; i != a.length ; i++) {
        if ((mask & 1<<i) != 0) {
            System.out.print("* ");
        } else {
            System.out.print(a[i]+" ");
        }
    }
    System.out.println();
}