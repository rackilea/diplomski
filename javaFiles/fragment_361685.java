public enum CustomEnumConstructor {
    Fibonacci(new int[]{1, 1, 2, 3, 5, 8, 13, 21}, new int[]{34, 55, 89, 144, 233, 377, 610}, 987),
    SternBrocot(new int[]{1, 1, 2, 1, 3, 2, 3, 1, 4, 3}), ;

    private final int[] array;

    private CustomEnumConstructor(int[] array1, int[] array2, int value) {
        int[] array12 = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, array12, 0, array1.length);
        System.arraycopy(array2, 0, array12, array1.length, array2.length);

        array = new int[array12.length + 1];
        System.arraycopy(array12, 0, array, 0, array12.length);
        array[array12.length] = value;
    }

    private CustomEnumConstructor(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }
}