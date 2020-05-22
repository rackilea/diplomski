Object obj = new int[] { 1, 2, 3, 4 };
try {
    int len = Array.getLength(obj);
    for (int i = 0; i < len; i++) {
        if (i != 0) {
            System.out.print(", ");
        }
        System.out.print(Array.get(obj, i));
    }
    System.out.println();
} catch (IllegalArgumentException iae) {
    iae.printStackTrace();
}