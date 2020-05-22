public static void main(String[] args) {
    method(new int[]{1});      // <- compile error
    method(new int[]{1},2);
    method(new int[]{1},2,new int[]{3,4});
    method(new int[]{1},2,new int[]{3,4},new int[]{5,6});
}

private static void method(int[] i1, int i2, int[]...i3) {
    // do something
}