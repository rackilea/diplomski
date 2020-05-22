public static boolean search(int[] array, int value) {
    int first = 0, last = array.length - 1, mid = ((first + last) / 2); //Divide by 2
    System.out.println(first + " - " + mid + " - " + last);
    while(true) {
        System.out.println(first + " - " + mid + " - " + last);
        if (value == array[mid]) {return true;}
        if (first == last || mid == last || mid == first) {return false;}

        if (value > array[mid]) {
            first = mid;
            mid = (last + first) / 2; //Divide by 2
        }
        if (value < array[mid]) {
            last = mid;
            mid = (first + last) / 2; //Divide by 2
        }
        System.out.println(first + " - " + mid + " - " + last);
    }
}