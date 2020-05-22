public static void main(String[] args) {
    int[] array = { 2,9,5,6,3 };


    int[] reversed = new int[array.length];

    for (int i = array.length; i > 0; i--) {
        reversed[reversed.length - i] = array[i-1];
    }

    for (int j : reversed) {
        System.out.print(j + ",");
    }


}