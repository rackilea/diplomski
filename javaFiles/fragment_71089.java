public static void methodExample(Object array1) {
    int len = Array.getLength(array1);
    for (int i = 0; i < len; i++) {
        System.out.printf("array1[%d] = %d%n", i, Array.get(array1, i));
    }
}

public static void main(String[] args) {
    methodExample(new int[] { 1, 2, 3 });
}