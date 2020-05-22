public static void gapSort (Comparable [] data, int size) {  
    int index;
    int gap, top;
    Comparable temp;
    boolean exchanged;

    double SF = 1.3;
    gap = size;

    do {
        exchanged = false;
        gap = (int) (gap / SF);
        if (gap == 0){
            gap = 1;
        }
        for (index = 1; index <= size - gap; index++) {
            if (data [index].compareTo(data [index + gap]) > 0) {
                temp = data [index];
                data [index] = data [index + gap];
                data [index + gap] = temp;
                exchanged = true;
            }
        }
    } while (exchanged || gap > 1);
}