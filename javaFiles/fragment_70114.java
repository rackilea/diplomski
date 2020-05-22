String[] a = {"student1", "student2"};
    String[] b = {"strudnt3"};
    String[] c = new String[a.length + b.length];
    // removing one object
    a[1] = null;
    // copying both arrays to c
    System.arraycopy(a, 0, c, 0, a.length);
    System.arraycopy(b, 0, c, a.length, b.length);
    // ignore null objects
    System.out.println(Arrays.toString(c));